### 1) Menu. Layout of "Online" status
##### Environment: MacOS, Chrome
#### Description: This test ensures that logged in user has "Online" status under the name.
#### Precondition: User navigates to http://v3.test.itpmgroup.com.
#### Steps to reproduce:
1. Log in to the portal
2. View status under the user's name
#### Expected result: The "Online" status is displayed.

### 2) Profile. Functionality of profile info updating
##### Environment: MacOS, Chrome
#### Description: This test ensures that user is able to update profile info.
#### Precondition: User navigates to http://v3.test.itpmgroup.com and logs in.
#### Steps to reproduce:
1. Click on the user's name on right corner
2. Click on "Профиль" button
3. Update user's info with correct data
4. Click on "Сохранить" button
#### Expected result: Info was updated and displayed correctly in the fields.

### 3) Deals. Addition of new spare to deal functionality
##### Environment: MacOS, Chrome
#### Description: This test ensures that user is able to create new spare for deal.
#### Precondition: User navigates to http://v3.test.itpmgroup.com and logs in.
#### Steps to reproduce:
1. Click on "Сделки" tab
2. Click on any existed deal
3. Click on + button for spares list
4. Fill out "Spare count", "Сделка" and "Деталь" fields with correct data
5. Click on the "Создать" button
#### Expected result: List with all spares for current deal is displayed.

### 4) Reports. Functionality of Report graph updating within new deal creation
##### Environment: MacOS, Chrome
#### Description: This test ensures that report graph updates dynamically after deal creation.
#### Precondition: User navigates to http://v3.test.itpmgroup.com and logs in.
#### Steps to reproduce:
1. Сlick on the "Сделки" tab
2. Click on + button for deals list
3. Set year via corresponding dropdown
4. Fill out "Тип сделки", "Покупатель" and "Поставщик" fields with correct data
5. Click on the "Создать" button
6. Click on "Отчёт" tab
7. View graph
#### Expected result: The Report graph was updated and displays new deal.

### 5) Service. Functionality of clicking on service work
##### Environment: MacOS, Chrome
#### Description: This test ensures that user is able to navigate to edit page of service work.
#### Precondition: User navigates to http://v3.test.itpmgroup.com and logs in.
#### Steps to reproduce:
1. Click on "Обслуживание" tab
2. Click on any service work from list
#### Expected result: Edit page for correct service work is open.