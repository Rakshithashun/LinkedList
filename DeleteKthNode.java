class LinkedList{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    Node head=null;
    public void insertAtBeg(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            newNode.next=null;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void insertAtEnd(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            newNode.next=null;
            return;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
    }
    public void insertAtPos(int data,int pos){
        Node newNode=new Node(data);
        Node current=head;
        while(current!=null && pos!=1){
            current=current.next;
            pos--;
            }
            
        newNode.next=current.next;
        current.next=newNode;
        
    }
    public void deleteAtBeg(){
        if(head==null){
            System.out.print("Empty");
            return;
        }
        head=head.next;
    }
    public void deleteAtEnd(){
        if(head==null){
            System.out.print("Empty");
            return;
        }
        Node current=head;
        while(current.next.next!=null){
            current=current.next;
        }
        current.next=null;
    }
    public void display(){
        Node current=head;
        while(current!=null){
            System.out.print(current.data+"->");
            current=current.next;
        }
        System.out.println("null");
    }
    public void deleteKthNode(int pos){
        Node current=head;
        int count=0;
        while(current.next!=null){
            if(count%pos==0){
                current.next=current.next.next;
                count++;
            }
            else{
                current=current.next;
                count++;
            }
            
        }
    }
  
}

public class Main{
     public static void main(String[] args){
         LinkedList l=new LinkedList();
         l.insertAtBeg(5);
         l.insertAtBeg(4);
         l.insertAtEnd(6);
         l.insertAtEnd(7);
         l.insertAtEnd(8);
         l.insertAtEnd(9);
         l.deleteKthNode(2);
         l.display();
    }
    
}
