package dataStructure.lru;

public class LRUPageFrame
{
    
    private static class Node
    {
        Node prev;
        Node next;
        int data;
        Node()
        {
        }
    }
    
    private int capacity;
    
    private int currentSize;
    
    private Node head;// ����ͷ
    
    private Node last;// ����β
    
    public LRUPageFrame(int capacity)
    {
        this.currentSize = 0;
        this.capacity = capacity;
        
    }
    
    /**
     * ��ȡ�����ж���
     * 
     * @param key
     * @return
     */
    public void access(int data)
    {
        
        Node node = find(data);
        // �ڸö����д��ڣ� ���ᵽ����ͷ
        if (node != null)
        {
            moveExistingNodeToHead(node);
        }
        else
        {
            node = new Node();
            node.data = data;
            // ���������Ƿ��Ѿ�������С.
            if (currentSize >= capacity)
            {
                removeLast();
            }
            addNewNodetoHead(node);
            
        }
    }
    
    /**
     * ���½� ����ӵ������ͷ��
     * 
     * @param node
     */
    private void addNewNodetoHead(Node node)
    {
        
        if (isEmpty())
        {
            node.prev = null;
            node.next = null;
            head = node;
            last = node;
        }
        else
        {
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
        this.currentSize++;
    }
    
    private Node find(int data)
    {
        Node node = head;
        while (node != null)
        {
            if (node.data == data)
            {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    
    /**
     * ɾ������β���ڵ� ��ʾ ɾ������ʹ�õĻ������
     */
    private void removeLast()
    {
        Node prev = last.prev;
        prev.next = null;
        last.prev = null;
        last = prev;
        this.currentSize--;
    }
    
    /**
     * �ƶ�������ͷ����ʾ����ڵ�������ʹ�ù���
     * 
     * @param node
     */
    private void moveExistingNodeToHead(Node node)
    {
        
        if (node == head)
        {
            
            return;
        }
        else if (node == last)
        {
            // ��ǰ�ڵ�������β�� ��Ҫ�ŵ�����ͷ
            Node prevNode = node.prev;
            prevNode.next = null;
            last.prev = null;
            last = prevNode;
            
        }
        else
        {
            // node ��������м䣬 ��node ��ǰ��ڵ���������
            Node prevNode = node.prev;
            prevNode.next = node.next;
            
            Node nextNode = node.next;
            nextNode.prev = prevNode;
            
        }
        
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
        
    }
    
    private boolean isEmpty()
    {
        return (head == null) && (last == null);
    }
    
    public String toString()
    {
        StringBuilder buffer = new StringBuilder();
        Node temp = head;
        while (temp != null)
        {
            buffer.append(temp.data);
            if (temp.next != null)
            {
                buffer.append(",");
            }
            temp = temp.next;
        }
        return buffer.toString();
    }
}