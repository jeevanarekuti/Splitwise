package com.example.Splitwise.services;

import com.example.Splitwise.models.*;
import com.example.Splitwise.repository.*;
import com.example.Splitwise.strategy.SettleUpStrategy;
import com.example.Splitwise.strategy.TwoQueuesSettleUpStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SettleUpService {

    private ExpenseUserPaidByRepository expenseUserPaidByRepository;
    private ExpenseUserOwedByRepository expenseUserOwedByRepository;
    private UserRepository userRepository;
    private ExpenseRepository expenseRepository;
    private GroupRepository groupRepository;
    private SettleUpStrategy settleUpStrategy;

    public SettleUpService(UserRepository userRepository, ExpenseUserOwedByRepository expenseUserOwedByRepository, ExpenseUserPaidByRepository expenseUserPaidByRepository, ExpenseRepository expenseRepository, GroupRepository groupRepository, SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserOwedByRepository = expenseUserOwedByRepository;
        this.expenseUserPaidByRepository = expenseUserPaidByRepository;
        this.expenseRepository = expenseRepository;
        this.groupRepository = groupRepository;
        this.settleUpStrategy = new TwoQueuesSettleUpStrategy();
    }


    public List<Transaction> settleUser(int userId){

        User user = userRepository.findById(userId);
        List<ExpenseUserPaidBy> expenseUserPaidByList = expenseUserPaidByRepository.findAllByUser(user);
        List<ExpenseUserOwedBy> expenseUserOwedByList = expenseUserOwedByRepository.findAllByUser(user);

        HashSet<Integer> expenseIdset = new HashSet<>();
        for(ExpenseUserPaidBy expenseUserPaidBy : expenseUserPaidByList){
            expenseIdset.add(expenseUserPaidBy.getExpense().getId());
        }
        for(ExpenseUserOwedBy expenseUserOwedBy : expenseUserOwedByList){
            expenseIdset.add(expenseUserOwedBy.getExpense().getId());
        }

        List<Integer> expenseIds = new ArrayList<>(expenseIdset);
        List<Expense> expenses = expenseRepository.findAllById(expenseIds);

        List<Transaction> transactions = settleUpStrategy.settle(expenses);
        return transactions;
    }

    public List<Transaction> settleGroup(int groupId){
        Group group = groupRepository.findById(groupId);
        return settleUpStrategy.settle(group.getExpenseList());
    }
}
