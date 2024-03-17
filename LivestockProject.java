package assignment;
public class LivestockProject {

		///////////////////////////// QUESTION 1 A INSTRCTIONS ////////////////
		    //private variables declared
		   private int membership_num;
		   private String name;
		   private String sName;
		   private String d_O_B;
		   private String gender;
		   private String loc;
		   private int initial_Num_of_livestock;
		   
		   public int project_total_heifers;
		   public int project_total_bulls;
		   public int project_total_livestock;
		  
		   
		   //class constructor and variables initialized to default values
		   public LivestockProject(){
		       membership_num = 0;
		       name = "";
		       sName = "";
		       d_O_B ="";
		       gender = "";
		       loc = "";
		       initial_Num_of_livestock = 0; 
		   }
		   //set methods
		   public void setMembership_num(int membership_num){
		       this.membership_num = membership_num;
		   }
		    public void setName(String name){
		        this.name = name;
		    }
		    public void setSName(String sName){
		        this.sName = sName;
		    }
		    public void setD_O_B(String d_O_B){
		        this.d_O_B = d_O_B;
		    }
		    public void setGender(String gender){
		        this.gender = gender;
		    }
		    public void setLoc(String loc){
		        this.loc = loc;
		    }
		    public void setInitial_Num_of_livestock(int initial_Num_of_livestock){
		        this.initial_Num_of_livestock = initial_Num_of_livestock;
		    }
		    
		    //get methods
		    public int getMembership_num(){
		        return membership_num;
		    }
		    public String getName(){
		        return name;
		    }
		    public String getSName(){
		        return sName;
		    }
		    public String getD_O_B(){
		        return d_O_B;
		    }
		    public String getGender(){
		        return gender;
		    }
		    public String getLoc(){
		        return loc;
		    }
		    public int getInitial_Num_of_livestock(){
		        return initial_Num_of_livestock;
		    }
		    
		///////////////////////////// QUESTION 1 A COMPLETED ////////////////



		   //METHOD'S VARIABLE DECLARATIONS 
		        
		        int heat_cows ;
		        int bulls;
		        int heifers;
		        int fertile_cows;
		        int serviced_cows;
		        int initial_bulls;
		        int initial_cows,total_cows;
		        int total_heifers=0;
		        int total_bulls=0;
		        int total_livestock_production = 0;
		        int total_heifer_project;
		        int total_bulls_project;
		        int total_livestock_project;
		        
		        

 ////////METHOD FOR ESTIMATED PRODUCTION FOR EACH MEMBER CALCULATIONS/////  
		  
		    public void Estimateproductin(int years, int initial_livestock,int num_of_members){
		    	
		    	//the array size determined
		    	int array_heifer[] = new int[years+1];
		    	int array_cows[] = new int[years+1];
		    	
		    	array_cows[0]=total_cows;
			    array_cows[1]=total_cows;
			       
			    total_heifer_project=0;
		        total_bulls_project =0;
		        total_livestock_project =0;
		        
		        //2 bulls per 100 ratio for a period of 5 years
		        initial_bulls = (int) (initial_livestock *0.02);
		        initial_cows = initial_livestock-initial_bulls;
		        total_cows = initial_cows;
		        
		       
		       for(int j=0;j< num_of_members;j++) {
		    	   

			        for( int i = 0 ; i < years; i++){ 
			        	
			        	if(i>=2) {
			        		array_cows[i]=array_heifer[i-2];
			        		total_cows+=array_heifer[i-2];
			        	}
			        	
			        	if(i>=7) {
			        		total_cows-=array_cows[i-6];
			        	}
			        	
			            //number of cows in heat = 0.90 * total number of cows
			        	heat_cows =(int) (0.90*total_cows);
			        	
			            //fertile cows = 0.90 * cows in heat
			        	fertile_cows = (int)(0.90*heat_cows);
			        	
			            //serviced cows = 0.95 x cows in heat
			        	serviced_cows = (int)(0.95*heat_cows);
			        	
			            //bull child = 0.30 * fertile cows
			        	bulls = (int)(0.30*fertile_cows);
			        	
			            //heifer child =  fertile cows-bulls
			        	heifers = fertile_cows-bulls;
			        	
			            //total bull child += bull child
			        	total_bulls+=bulls;
			        	
			            //total heifer child += heifer child
			        	total_heifers+=heifers;
			        	
			        	//store number of heifers produced each year into an array
			        	array_heifer[i] =heifers;
			        	
			        	
			        	//total livestock production 
			        	
			        	total_livestock_production = fertile_cows;	
		        
		        }
			        
			        
		        total_heifer_project+=total_heifers;
		        total_bulls_project += total_bulls;
	
		      
		        
		    }
		       
		    // Display the results
		        System.out.println("Estimated Bulls Production                             : "+ total_bulls);
		        System.out.println("Estimated Heifer Production                            : "+total_heifers);
		        System.out.println("Estimated Livestock Production                         : "+(total_bulls+total_heifers));
		       
		       this.project_total_bulls = total_bulls_project;
		       this.project_total_heifers = total_heifer_project;
		      

		    }
		    
 ////////METHOD FOR ESTIMATED PRODUCTION FOR THE ENTIRE PROJECT CALCULATIONS///// 
		    public void Entireproject(){
		    	System.out.println("total bull project: "+this.project_total_bulls);
		    	System.out.println("total heifer project: "+this.project_total_heifers);
		    	System.out.println("total livestock project:"+ (this.project_total_bulls + this.project_total_heifers));
		    	
		    }
			
				
			}
		    	
		    


