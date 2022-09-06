package com.coding.exercises.lists;

import java.util.HashMap;
import java.util.Map;

import com.coding.exercises.utils.Node;

public class CopyWithRandomPointers {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node newNode = new Node(head.val);
        Node itr = head, ret = newNode;
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(itr, newNode);
        
        itr = itr.next;
        // itr is on 2nd element.
        // newNode is on new 1st element.
        while (itr != null) {
            
            // Create the next node.
            newNode.next = new Node(itr.val);
            newNode = newNode.next;
            
            // itr on 2nd, newNode also on 2nd.
            // Note down the mapping.
            nodeMap.put(itr, newNode);
            itr = itr.next;
        }
        
        for(Node oldNode: nodeMap.keySet()) {
            newNode = nodeMap.get(oldNode);
            if (oldNode.random != null) {
                Node newRandom = nodeMap.getOrDefault(oldNode.random, null);
                newNode.random = newRandom;
            }
        }

        return ret;
    }
}
