# DataBase management software for a Grocery Store in Java using MySQL WampServer


# Functions (for both products and users)

- Create
- Read
- Update
- Delete


# Business Rules

- By default the admin is "root" and password is "123".
- Users can be a default User (1), Admin (2) or Cashier (3).
- Users can be deleted from the database.
- Only the admin can add Users or Cashiers.
- Created products have the login of the person who created it.
- If a product is updated, it will have the login of the person who last did it.
- Deleted items will change it status from "ativo" (active) to "inativo" (inactive).


# Setup

To use this software you need the following:
* [Wampserver](https://sourceforge.net/projects/wampserver/) (with MySQL version 5.7.28)

After installing Wampserver and opening it, you will have to create a database with the charset `utf8_general_ci` and import the file `mercadinho.sql` from this repository aswell.

After importing the tables, all that is left is Open the MercadinhoDB.jar inside the `dist` folder


# The program

* [The diagram for the DB](https://i.imgur.com/KXLstKJ.png)
* [Launcher for selecting db manage or Cashier system](https://i.imgur.com/MF6C3Oq.png)
* [Cashier area (currently not implemented)](https://i.imgur.com/IjXsnbx.png)
* [Homepage with a dashboard](https://i.imgur.com/SfB8Yt1.png)
* [Area for products CRUD](https://i.imgur.com/Puhji3F.png)
* [Area for users CRUD](https://i.imgur.com/GhDRHxS.png)
* [Area for inactive products](https://i.imgur.com/dWLq1Gt.png)
