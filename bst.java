class Node {
    int key;
    Node left,right;
    Node(int key){
        this.key=key;
        left=right=null;
    }
}
 class Main{
    static Node insert(Node root,int key) {
        if(root==null){
            return new Node(key);
        }
        if(root.key==key){
            return root;
        }
        if(key>root.key){
            root.right=insert(root.right, key);
        }
        else {
            root.left=insert(root.left, key);
        }
        return root;
    }

    
    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
    static void preorder(Node root){
        if(root!=null){
            System.out.print(root.key+" ");

            preorder(root.left);
            
            preorder(root.right);
        }
    }
      static void postorder(Node root){
        if(root!=null){
            

            postorder(root.left);
            
            postorder(root.right);
            System.out.print(root.key+" ");
        }
    }
  
    static Node delete(Node root,int key){
        if(root==null){
            return root;
        }
        if(key>root.key){
            root.right=delete(root.right,key);
        }
        else if(key<root.key){
            root.left=delete(root.left,key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            Node minnode=findmin(root.right);
                root.key=minnode.key;
                root.right=delete(root.right,minnode.key);
            }
            return root;
    }
            
            public static Node findmin(Node root){
                while(root.left!=null){
                    root=root.left;
                }
                return root;
            }
           
        
    
    
    
    public static void main(String args[]){
        Node root=null;
        /*root=insert(root,50);
        root=insert(root,20);
        root=insert(root,30);*/
        int a[]={30,40,50,12,120,35,15,18};
        for(int i=0;i<a.length;i++){
            //a[i]=sc.nextInt();
            root=insert(root,a[i]);
        }
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        root=delete(root,30);
        inorder(root);
    }
}
