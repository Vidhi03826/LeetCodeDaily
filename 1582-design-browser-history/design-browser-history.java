class Node{
    String data;
    Node next;
    Node back;

    Node(String data){
        this.data= data;
        this.next = null;
        this.back = null;
    }
}
class BrowserHistory {
     Node currPage;

    public BrowserHistory(String homepage) {
        currPage = new Node(homepage);
    }
    
    public void visit(String url) {
       Node newNode = new Node(url);
       currPage.next = newNode;
       newNode.back = currPage;
       currPage = newNode;
        
    }
    
    public String back(int steps) {
       while(steps>0){
        if(currPage.back !=null){
            currPage = currPage.back;
        }
        else break;
         steps--;
       }
      
       return currPage.data;
    }
    
    public String forward(int steps) {
        while(steps>0){
        if(currPage.next !=null){
            currPage = currPage.next;
        }
        else break;
         steps--;
       }
      
       return currPage.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
        
 