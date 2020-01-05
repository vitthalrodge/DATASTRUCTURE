

	/******************************************************************************
	 *  Purpose: A utility file which contains the logic of all Datastructur programs
	 *
	 *  @author  vitthal rodge
	 *  @version 1.0
	 *  @since   12-09-2019
	 *
	 ******************************************************************************/
	package DatastructureANDAlgorthm;

	import java.io.FileWriter;
	import java.util.Scanner;

	public class DataStructurUtility<T> {
		
		public T obj;  
		public void add(T obj){
			this.obj=obj;
		}  
		public T get(){
			return obj;
		}
		
		 Node front=null;
		 Node rear=null;
		 Node head = null;
		 Node top=null;
		 int size;
	   
		 Scanner scanner=new Scanner(System.in);
			
		    /**
		     * purpose : create function to Accept the integer values from user
		     * 
		     * @return : value return integer value
		     */
		    
		    public int scanInt() {
		    	
		      int value = scanner.nextInt();
			  return value;
			
		    }

		    /**
		     * purpose : create function to Accepstringt the String values from user
		     * 
		     * @return : value return String value
		     */
		    
		    public  String scanString() {
		    	String value = scanner.next();
		    	return value;
		    }
		    public double scanDouble() {
		    	double value=scanner.nextDouble();
		    	return value;
		    }
			
			/**
			 * purpose : Dynamically Add and Delete String list and integer list
			 * 
			 * @author admin vitthal
			 *
			 */
			 class Node{
				private T data;
		   	   // private T string;
		   	    private Node next;
		   	    
		   	    public Node() {
		   	    data=null;
		   	    next=null;
		   	    }
		   	    public Node(T data,Node next) {
		   	    	this.data=data;
		   	    	this.next=next;
		   	    	
		   	    }
		   	    
		   	  /* 
		   	    public Node(String string,Node next) {
		   	    this.string=string;
		   	    this.next=next;
		   	    }
		   	    */
		    }
			
			
			 /**
			  * purpose : this function used to add string at first posititon 
			  * 
			  * @param string : string element
			 */
			public void addFirst(T string) {
				Node newNode=new Node();
				newNode.data=string;
				if(head==null) {
					head=newNode;
				}else {
					Node temp=newNode;
					temp.next=head;
					head=temp;
					
				}
				size++;
			}
			
			
			 /**
			  * purpose : this function used to add string list dynamically
			  * 
			  * @param string : string element
			 */
			public void addList(T data) {
			    	Node newNode=new Node();
			    	newNode.data=data;
			    	
			    	if(head==null) {
			    		head=newNode;
			    	}else {
			    	   Node	temp=head;
			    	   while(temp.next!=null) {
			    		   temp=temp.next;
			    	   }
			    	   temp.next=newNode;
			    	}
			    	size++;
			    }
			
			
			 /**
			  * purpose : this function used to add string at position number in list
			  * 
			  * @param string : string element
			 */
			public void addAdPosition(String string) {
				
			}
			    
			    /**
			     * purpose : this function used for display the string elements in list
			     * 
			     */
			    public void viewList() {
			    	
			    	if(head==null) {
			    		System.out.println("List is empty : ");
			    	}else {
			    		Node temp=head;
			    		while(temp!=null) {
			    			System.out.print(temp.data+" ");
			    			temp=temp.next;
			    		}
			    	}
			    }
			    
	             public void viewSate() {
			    	int i=0;
			    	if(head==null) {
			    		System.out.println("List is empty : ");
			    	}else {
			    		Node temp=head;
			    		while(temp!=null) {
			    			i=i+1;
			    			System.out.println(i+". "+temp.data+" ");
			    			temp=temp.next;
			    		}
			    	}
			    }
			    
			    
			    /**
			     * purpose : this function used to delete first element in string list
			     * 
			     */
			    public void deleteFirst() {
			    	if(head==null) {
			    		System.out.println("List is empty : ");
			    	}else {
			    		head=head.next;
			    	}
			    	size--;
			    }
			    
			    
			    /**
			     * purpose : this function used to delete last element in string list
			     * 
			     */
			    public void deleteLast() {
			    	Node temp=head;
			    	for(int index=1;index<size-1;index++) {
			    		temp=temp.next;
			    	}
			    	temp.next=null;
			    	size--;
			    }
			    
			    
			    /**
			     * purpose : this function used to delete the element at position in string list
			     * 
			     * @param position : postion number of delete element
			     * 
			     */
			    public void deleteAtPosition(int position) {
			    	if(position==1) {
			    		deleteFirst();
			    	
			    	}else if(position==size) {
			    		deleteLast();
			    		
			    	}else if(position>1 && position<=size-1){
			    		Node temp,temp1;
			    		temp=head;
			    		for(int index=1;index<position-1;index++) {
			    			temp=temp.next;
			    		}
			    		temp1=temp.next;
			    		temp.next=temp1.next;
			    		size--;
			    	}else {
			    		System.out.println("position is not found : ");
			    	}
			    	
			    }
			    
			    
			    /**
			     * purpose : this function used to search string element in list if string element is not found 
			     *           than add the string element in list else if string element is found than delete the
			     *           string element in list
			     *           
			     * @param string : serching element in list
		 	     */
			    public void searchData(T string) {
			    	Node temp=head;
			    	int count=0;
			    	int position=1;
			    	while(temp!=null) {
			    	if(temp.data.equals(string)) {
			    		count=1;
			    		deleteAtPosition(position);
			    	}
			    	position=position+1;
			    	temp=temp.next;
			      }
			    	if(temp==null && count==0) {
			    	  addList(string);
			    	}
			    	
			    }
			    
			    /**
			     * purpose : this function used to add string element in file using linke list
			     * 
			     */
			    public  void addFile() {
			    	try {
			    		 FileWriter write=new FileWriter("//home/admin/seleninum/eclipse-workspace/JavaPrograms/src/com/bridgelabz/datastructureprograms/OrderListAdd.txt");
				            Node temp=head;
				            while(temp!=null) {
				            	write.write(temp.data+" ");
				            	temp=temp.next;
				            	System.out.println("file");
				            }
				            write.close();
			    	}catch (Exception e) {
						System.out.println("Not write anythink in file : ");
					}
			    }
			    public  void addState() {
			    	try {
			    		 FileWriter write=new FileWriter("/home/admin/seleninum/eclipse-workspace/JavaPrograms/src/com/bridgelabz/jsonfiles/states.txt");
				            Node temp=head;
				            while(temp!=null) {
				            	write.write(temp.data+" ");
				            	temp=temp.next;
				            }
				            write.close();
			    	}catch (Exception e) {
						System.out.println("Not write anythink in file : ");
					}
			    }
			    /**
				  * purpose : this function used to add integer data at first posititon 
				  * 
				  * @param data :  this element is added in list
				 */
				public void addFirst1(T data) {
					Node newNode=new Node();
					newNode.data=data;
					if(head==null) {
						head=newNode;
					}else {
						Node temp=newNode;
						temp.next=head;
						head=temp;
						
					}
				}
				
				/**
				 * purpose : this function used to add integer data at last posititon 
				 * 
				 * @param data : this element is added in list
				 */
				public void addLast(T data) {
			    	Node newNode=new Node();
			    	newNode.data=data;
			    	
			    	if(head==null) {
			    		head=newNode;
			    	}else {
			    	   Node	temp=head;
			    	   while(temp.next!=null) {
			    		   temp=temp.next;
			    	   }
			    	   temp.next=newNode;
			    	}
			    	size++;
			    }
			
				
				/**
				 * purpose : this fuction is used to add element at particular position
				 * @param data : element to add list
				 * @param postion : index number of list
				 */
				public void inseartAtPosition(T data,int postion) {
				
					if(postion==1) {
						addFirst1(data);
						
					}else if (postion==size+1) {
						addLast(data);
						
					}else if(postion>1 && postion<=size){
						Node newNode = new Node();
						newNode.data=data;
						Node temp = head;
						
						for(int i=1;i<postion-1;i++) {
						    temp=temp.next;	
						}
						newNode.next=temp.next;
						temp.next=newNode;
						size++;
					}else {
						System.out.println("index number is wrong you insert index number between 1 to "+(size+1)+" only");
					}
					
				}
			
			
				/**
			     * purpose : this function used for display the integer elements in list
			     * 
			     */
			    public void printList() {
			    	
			    	if(head==null) {
			    		System.out.println("List is empty : ");
			    	}else {
			    		Node temp=head;
			    		while(temp!=null) {
			    			System.out.print(temp.data+" ");
			    			temp=temp.next;
			    		}
			    	}
			    }
			    
			    
			    /**
			     * purpose : this function used to search string element in list if string element is not found 
			     *           than add the string element in list else if string element is found than delete the
			     *           string element in list
			     *           
			     * @param string : serching element in list
		 	     */
			    public void search(T data) {
			    	Node temp=head;
			    	int count=0;
			    	int position=1;
			    	while(temp!=null) {
			    	if(temp.data==data) {
			    		count=1;
			    		deleteAtPosition(position);
			    	}
			    	position=position+1;
			    	temp=temp.next;
			      }
			    	if(temp==null && count==0) {
			    	  addLast(data);
			    	}
			    	
			    }
			    
			    /**
			     * purpose : this function is used for finding the index number of your elements 
			     * 
			     * @param data : searching element in list
			     * @return : return index number
			     */
			    
			    public  int index(T data) {
			    	Node search=head;
			    	int count=1;
			    	int index=0;
			    	while(search != null) {
			    		if(search.data==data) {
			    			index=count;
			    		  break;
			    		}
			    		count++;
			    		search=search.next;
			    	}
			    	return index;
			    }
			    
			    
			    /**
			     *purpose : this function is used to checked  list is empty or not  
			     *
			     */
			    public void isEmpty() {
			    	if(head==null) {
			    		System.out.println("List is Empty : ");
			    	}else {
			    	    System.out.println("List is not empty");
			    	}
			    		
			    }
			    
			    public int getListSize() {
			    	return size;
			    }
			    /**
			     * purpose : this function used to sort element in the list 
			     */
			    public void sortList() {
			    	Node current;
			    	current=head;
			    	Node index=current;
			    	T temp;
			    	if(head==null) {
			    		isEmpty();
			    		}else {
			    	while(current!=null) {
			    		index=current.next;
			    		while(index!=null) {
			    			if(current.data.hashCode()>index.data.hashCode()) {
			    			   temp=current.data;
			    			   current.data=index.data;
			    			   index.data=temp;
			    			}
			    			index=index.next;
			    		}
			    		current=current.next;
			    		
			    	}
			      }
			    }
			    
			  /**
			   * purpose : this fuction is uesd to search element in file  
			   * 
			 * @param data : data of list
			 * @return : true or false regarding value
			 */
			public boolean searchBoolean(T data) {
				  Node temp;
				  temp=head;
				  
				  while(temp!=null) {
					  if(temp.data.hashCode()==data.hashCode()) {
						  return true;
					  }
					  temp=temp.next;
				  }
				  
				  return false;
			  }
			
			
			/*
			 *
			 * Stak programs logic
			 *  
			 * */
			  
			
			
			/**
			 * purpose : this function is used to check list is empty or not
			 */
			public void isEmptySatck() {
				if(top==null) {
					System.out.println("List is empty : ");
				}else {
					System.out.println("List is not empty : ");
				}
			}
			
			/**
			 *purpose : this function is used to print the stack value
			 * 
			 */
			public void printSack() {
				   
				   if(top==null) {
					   isEmpty();
				   }else {
					   Node temp=top;
					   while(temp!=null) {
						   System.out.print(temp.data+" ");
						   temp=temp.next;
					   }
				   }
			   }
			
			  /**
			   * purpose : this function is used for add element in stack
			   * 
			   * @param data : element of added 
			   */
			public void push(T data) {
				  Node newTop=new Node();
				  newTop.data=data;
				  if(top==null) {
					  top=newTop;
				  }else {
					  newTop.next=top;
					  top=newTop;
				  }
				  size++;
				  
			  }
			
			/**
			 * purpose : Delete satck element in the list 
			 */
			public void pop() {
				top=top.next;
				if(size>=0) {
				size--;
				}else {
					System.out.println("here not elements : ");
				}
			}
			
			public T peekSatck() {
				return top.data;
			}
			
			
			/*
			 *
			 * Queue programs logic
			 *  
			 * */
			
			/**
			 * purpose : this function used to add element in queue
			 * 
			 * @param data : data add to list
			 */
			public void enqueue(T data) {
				Node newNode = new Node();
				newNode.data=data;
				if(front==null) {
					front=rear=newNode;
					size++;
				}else {
					
					rear.next=newNode;
					rear=rear.next;
					size++;
				}
				
			}
			
			/**
			 * purpose : this function used to display the queue element in list
			 */
			public void printQueue() {
				if(front==null) {
					isEmpty();
				}else {
					Node temp =front;
					while(temp!=null) {
						System.out.println(temp.data);
						temp=temp.next;
							
					}
				}
			}
			
			/**
			 * purpose : this function used to delete the element in list
			 */
			public void dequeue() {
				if(front==null) {
					isEmpty();
				}else {
					front=front.next;
					size--;
				}
				
			}
			/**
			 * purpose : this function used for return the front element of queue
			 * 
			 * @return : return front element 
			 */
			public T peekQueue() {
				return front.data;
			}
			
			/**
			 * purpose : this fuction used to add element int last(front) of queue
			 * @param data : added elements
			 */
			public void addRear(T data) {
				Node newNode = new Node();
				newNode.data=data;
					
				if(front==null) {
				   front=newNode;
				   rear=newNode;
				} else {
					
					while(rear.next!=null) {
						rear=rear.next;
					}
					rear.next=newNode;
					rear=newNode;
				}
				size++;
			}
			
			/**
			 * purpose : this function is used for print the deque value
			 * 
			 */
			public void printDeque() {
			    
				if(front==null || rear==null) {
					isEmpty();
				}else {
					Node temp=front; 
					while(temp!=null) {
						System.out.println(temp.data);
						temp=temp.next;
					}
				}
				
			}
			
			
			/**
			 * purpose : this fuction used to add element int frist(rear) of queue
			 * 
			 * @param data : added elements
			 */
			public void addFront(T data) {
				Node newNode = new Node();
				newNode.data=data;
				if(front==null) {
					front=newNode;
					rear=newNode;
				}else {
					newNode.next=front;
					front=newNode;
				}
				size++;
			}
			
			/**
			 * purpose : this function return rear value of queue 
			 * @return : return rear
			 */
			public T peekRear() {
				return rear.data;
			}
			
			
			/**
			 * purpose : this function return front value of queue 
			 * @return : return front
			 */
			public T peekFront() {
				return front.data;
			}
			
			/**
			 * purpose : this function is used to remove the element in front side
			 * 
			 */
			public void removeFront() {
				if(front==null) {
					isEmpty();
				}else {
					front=front.next;
				}
				size--;
			}
			
			/**
			 * purpose : this function is used to remove the element in rear side(last)
			 * 
			 */
			public void removeRear() {
				if(rear==null) {
					isEmpty();
				}
				else if(front==rear)
				{
					front = rear = null;
				}
				else {
					Node temp=front;
					while(temp.next!=rear) {
					     temp=temp.next;	
					}
//					temp.next=null;
//					rear=temp;
					temp.next = null;
					rear = temp;
				}
				size--;
			}
			
			/**
			 * purpose : this function used to display the hash element in list
			 */
			public void printHash() {    
					if(front==null || rear==null) {
						isEmpty();
					}else {
						Node temp=front; 
						while(temp!=null) {
							System.out.print(temp.data+" ");
							temp=temp.next;
						}
					}
					
				}
				
			
	}

	
	
	
}
