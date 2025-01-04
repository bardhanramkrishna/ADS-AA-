class AvlNode
{
    int key;
    int height;
    AvlNode left,right;
    AvlNode(int key)
    {
        this.key=key;
        height=0;
        left=right=null;
    }

}
class Avltree
{
    static int height(AvlNode Node)
    {
        if(Node==null)
            return -1;
        else
            return Node.height;
    }


    static AvlNode leftrotation(AvlNode k2)
    {
        AvlNode k1=k2.left;
        k1.right=k2.left;
        k2=k1.right;
        k1.height=Math.max(height(k1.left),height(k1.right))+1;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        return k1; 
    }

    static AvlNode rightrotation(AvlNode k1)
    {
        AvlNode k2=k1.right;
        k1.right=k2.left;
        k1=k2.left;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.left),height(k1.right))+1;
        return k2;
    }

    static AvlNode doubleleftright(AvlNode k3)
    {
        k3.left=rightrotation(k3.left);
        return leftrotation(k3);
    }

    static AvlNode doublerightleft(AvlNode k1)
    {
        k1.right=leftrotation(k1.right);
        return rightrotation(k1);
    }

    public static AvlNode insert(AvlNode Node,int key)
    {
        if(Node==null)
            return new AvlNode(key);
        if(key<Node.key)
        {
            Node.left=insert(Node.left,key);
            if(height(Node.left)-height(Node.right)==2)
            {
                if(key<Node.left.key)
                     Node=leftrotation(Node);
            
                else 
                    Node=doubleleftright(Node);
            }
        }
        else if(key>Node.key)
        {
            Node.right=insert(Node.right,key);
            if(height(Node.right)-height(Node.right)==-2)
            {
                if(key>Node.right.key)
                    Node=rightrotation(Node);
                else
                    Node=doublerightleft(Node);
            }
        }
            Node.height=Math.max(height(Node.left),height(Node.right)+1);
            return Node;

    }

    static AvlNode inorder(AvlNode Node)
    {
        if(Node!=null)
        {
            inorder(Node.left);
            System.out.print(Node.key+" ");
            inorder(Node.right);
        }
        return Node;
    }
public static void main(String args[])
{
    AvlNode Node=null;
    int a[]={40,20,50,80,70};
    for(int i=0;i<a.length;i++){
        Node=insert (Node,a[i]);
        
    }
    inorder(Node);
}
}



