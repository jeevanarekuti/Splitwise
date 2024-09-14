package com.example.Splitwise.strategy;

import com.example.Splitwise.models.*;
import org.springframework.data.util.Pair;

import java.util.*;

public class TwoQueuesSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settle(List<Expense> expenseList) {
        Map<Integer,Double> condesedExpenses = new HashMap<>();

        for(Expense expense : expenseList){
            for(ExpenseUserPaidBy expenseUserPaidByPaidBy : expense.getPaidBy()){
                int userId = expenseUserPaidByPaidBy.getUser().getId();
                condesedExpenses.put(userId,condesedExpenses.getOrDefault(userId,0.0) + expenseUserPaidByPaidBy.getAmount());
            }
            for(ExpenseUserOwedBy expenseUserOwedBy : expense.getOwedBy()){
                int userId = expenseUserOwedBy.getUser().getId();
                condesedExpenses.put(userId,condesedExpenses.getOrDefault(userId,0.0) - expenseUserOwedBy.getAmount());
            }
        }

        Queue<Pair<Integer,Double>> maxHeap = new PriorityQueue<>(new Comparator<Pair<Integer,Double>>() {
            @Override
            public int compare(Pair<Integer, Double> p1, Pair<Integer, Double> p2) {
                return p1.getFirst() - p2.getFirst();
            }
        });

        Queue<Pair<Integer,Double>> minHeap = new PriorityQueue<>(new Comparator<Pair<Integer,Double>>() {
            @Override
            public int compare(Pair<Integer, Double> p1, Pair<Integer, Double> p2) {
                return p2.getFirst() - p1.getFirst();
            }
        });

        for(Map.Entry<Integer,Double> entry : condesedExpenses.entrySet()){
            if(entry.getValue() > 0){
                maxHeap.add(Pair.of(entry.getKey(),entry.getValue()));
            }
            else{
                minHeap.add(Pair.of(entry.getKey(),entry.getValue()));
            }
        }

        List<Transaction> transactionList = new ArrayList<>();
        while(!maxHeap.isEmpty() && !minHeap.isEmpty()){
            Pair<Integer,Double> pair1 = maxHeap.poll();
            Pair<Integer,Double> pair2 = minHeap.poll();

            double amt = Math.min(pair1.getSecond(), Math.abs(pair2.getSecond()));

            if((pair1.getSecond() - amt)>0){
                maxHeap.add(Pair.of(pair1.getFirst(),(pair1.getSecond() - amt)));
            }
            if((pair2.getSecond() + amt)>0){
                minHeap.add(Pair.of(pair2.getFirst(),(pair2.getSecond() + amt)));
            }

            Transaction transaction = new Transaction();
            transaction.setAmount(amt);
            transaction.setPaid(pair1.getFirst());
            transaction.setOwed(pair2.getFirst());
            transactionList.add(transaction);
        }

        return transactionList;
    }
}
