Feature: This feature is for Register on the website using the email address
  			 Validate the Home page Add a product to the cart and verify the payment page

  #Change the test datas for creating a new account
  @Registeration
  Scenario Outline: Register by Creating an Account on the Website using the email address
    Given User clicks on continue button for Registeration
    And User enters First Name <firstName>, Last Name <lastName> and E-mail address <email>
    And User selects country <country> and <state> from the dropdown
    And User enters Address1  <address>, City <city> and ZIP code <zip>
    And User enters Login Name <loginName>, desired password as <password> and confirm your password as <confPass>
    And User checks the PrivacyPolicy checkbox
    When User clicks on continue button
    Then Validate for the successful account creation

    Examples: 
      | firstName | lastName | email                    | country | state     | address                    | city      | zip    | loginName | password | confPass |
      | Kennedya123   | Hoppe13432    | colten_hoprewp1234@gmail.com | India   | Karnataka | 0508 Berge Course Apt. 018 | Bangalore | 560029 | 0pdasdhgfd  | 3e12314tgdd   | 3e12314tgdd   |

  #Enter the user credentials
  @Login
  Scenario Outline: Login and check for the Home Page and Welcome Name
    Given User enters the <loginUserName> and <loginUserPass>
    When User clicks on Login button
    Then Validate the HomePage is displayed

    Examples: 
      | loginUserName  | loginUserPass     |
      | TestLoginName1 | TestPassowrd11234 |
      
  # The product required should be added to the cart
  @Cart
  Scenario: Add a Product to the Cart and check the Payment details
    Given User Navigates to MEN catagery
    When User Adds items to the cart
    And User clicks on cart button
    Then check for the items added to the cart
    And Verify the payment details for the products added
