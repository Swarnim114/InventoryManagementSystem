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

  ### Class Diagram  


![InventoryManagementSystem](https://github.com/Swarnim114/InventoryManagementSystem/assets/134050970/e0f40910-98f5-4fcc-ba2d-c621ecad1012)

### Database used 
- **MariaDB**

### Basic Exceptions
- Invalid Item Update Exceptions
- Invalid Supplier Items Exception
- Invalid Supplier Update Exception
- Invalid Transaction Exceptions
- Item Not Found Exception
