### Item management Models
- **Models**
   - Items - Item id(Auto Increament)
        - Name
        - Quantity
        - Supplier 
        - Price
-  **Item Service**  
	    -  crud operations
	    - Items can be updated except the supplier



###  Supplier Management
 - **Models** 
      - Supplier 
         - name 
         - contact 
         - description
         - id 
- **Supplier Service**
	    - add / update / delete -- suppliers
	    


### Transaction Management
-  **Model** 
      - Transaction id 
      - item id 
      - Transaction Type 
      - Quantity
      - Date
 -  **Fintionalites** - record transactions 
	    - Crud operations


![[InventoryManagementSystem.png]]

### Database used 
- **MariaDB**

### Basic Exceptions
- Invalid Item Update Exceptions
- Invalid Supplier Items Exception
- Invalid Supplier Update Exception
- Invalid Transaction Exceptions
- Item Not Found Exception


### Team Members 
 - Swarnim - Database integration,Item service and controller
 - Sushant Singh - Exceptions
 - Divyanshu Pandey - Models , Help in planning
 - Kumar kartikay -Supplier Service , Transaction controller
 - Prince - transaction service , Checking working via postman
 - Rushabh - Supplier controller , ReadMe Documentation
