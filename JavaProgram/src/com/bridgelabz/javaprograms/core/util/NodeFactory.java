
package com.bridgelabz.javaprograms.core.util;

import com.bridgelabz.javaprograms.core.datastructures.Node;

/******************************************************************************
 *  Purpose: Supplies the Node of type T
 *
 *  @author  BridgeLabz/Sudhakar
 *  @version 1.0
 *  @since   17-01-2019
 *  * @param <T>
 *  
 *******************************************************************************/
public class NodeFactory<T> {
    public static <T> Node<T> getNode(T item){
    	Node<T> newNode = new Node<T>();
    	newNode.setData(item);
    	newNode.setNext(null);
    	return newNode;
    }
    
}
