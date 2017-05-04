package dataStructure.stack;

public class StackUtil
{
    
    /**
     * ����ջ�е�Ԫ����Integer, ��ջ����ջ���� : 5,4,3,2,1 ���ø÷����� Ԫ�ش����Ϊ: 1,2,3,4,5 ע�⣺ֻ��ʹ��Stack�Ļ�����������push,pop,peek,isEmpty��
     * ����ʹ������һ��ջ������
     */
    public static void reverse(Stack<Integer> s)
    {
        if (s == null || s.isEmpty())
        {
            return;
        }
        
        Stack<Integer> tmp = new Stack<Integer>();
        while (!s.isEmpty())
        {
            Integer top = (Integer)tmp.pop();
            addToBottom(s, top);
            // tmp.push(s.pop());
        }
        // while (!tmp.isEmpty())
        // {
        // Integer top = (Integer)tmp.pop();
        // addToBottom(s, top);
        // }
        
    }
    
    public static void addToBottom(Stack<Integer> s, Integer value)
    {
        if (s.isEmpty())
        {
            s.push(value);
        }
        else
        {
            Integer top = (Integer)s.pop();
            addToBottom(s, value);
            s.push(top);
        }
    }
    
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
    
    /**
     * ɾ��ջ�е�ĳ��Ԫ�� ע�⣺ֻ��ʹ��Stack�Ļ�����������push,pop,peek,isEmpty�� ����ʹ������һ��ջ������
     * 
     * @param o
     */
    public static void remove(Stack<Integer> s, Object o)
    {
        if (s.isEmpty() || s == null)
        {
            return;
        }
        Stack<Integer> temp = new Stack<Integer>();
        while (!s.isEmpty())
        {
            Object obj = s.pop();
            if (obj != o)
            {
                temp.push(obj);
            }
        }
        while (!temp.isEmpty())
        {
            s.push(temp.pop());
        }
    }
    
    /**
     * ��ջ��ȡ��len��Ԫ��, ԭ����ջ��Ԫ�ر��ֲ��� ע�⣺ֻ��ʹ��Stack�Ļ�����������push,pop,peek,isEmpty�� ����ʹ������һ��ջ������
     * 
     * @param len
     * @return
     */
    public static Object[] getTop(Stack<Integer> s, int len)
    {
        if (s.isEmpty() || s == null || s.size() < len || len <= 0)
        {
            return null;
        }
        Stack<Integer> temp = new Stack<Integer>();
        Object[] objs = new Object[s.size()];
        int i = 0;
        while (!s.isEmpty())
        {
            Object o = s.pop();
            temp.push(o);
            objs[i] = o;
            i++;
            if (i == len)
            {
                break;
            }
        }
        // �ٴν�����ѹ��ջ
        while (!temp.isEmpty())
        {
            s.push(temp.pop());
        }
        return objs;
    }
    
    /**
     * �ַ���s ���ܰ�����Щ�ַ��� ( ) [ ] { }, a,b,c... x,yz ʹ�ö�ջ����ַ���s�е������ǲ��ǳɶԳ��ֵġ� ����s = "([e{d}f])" , ����ַ����е������ǳɶԳ��֣� �÷�������true
     * ��� s = "([b{x]y})", ����ַ����е����Ų��ǳɶԳ��ֵģ� �÷�������false;
     * 
     * @param s
     * @return
     */
    public static boolean isValidPairs(String s)
    {
        Stack<Integer> temp = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);// �ַ����ֽ�
            if (c == '(' || c == '[' || c == '{')
            {
                temp.push(c);
            }
            else if (c == '}')
            {
                char top = (char)temp.pop();
                if (top != '{')
                {
                    return false;
                }
            }
            else if (c == ']')
            {
                char top = (char)temp.pop();
                if (top != '[')
                {
                    return false;
                }
            }
            else if (c == ')')
            {
                char top = (char)temp.pop();
                if (top != '(')
                {
                    return false;
                }
            }
        }
        return true;
    }
}
