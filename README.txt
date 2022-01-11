Object-Oriented Pattern
========================
The singleton is implemented in the Account.java class in the model package of our AlphaCare project. The singleton is relatively simple to implemented, only need a new private static variable of Account type. This is instantiated if it doesn`t exist and then returned by the getAccount() method of this same class. The public and static nature of this method means that it can be referenced anywhere to return the representation of this single Account object. This means an accountID can be retrieved from anywhere in the application after the user has logged in.

UI Design Pattern
==================
The home link is currently only implemented in the PatientDashboard. On this screen if you click the AlphaCare logo in the top right it will return you to where you landed after signing in and reset everything. This may not be necessary when the user could just click the “Dashboard” tab, but as the application grows and more screens are added, this home link will allow the user to quickly go back to the beginning of the navigation in the application. 
