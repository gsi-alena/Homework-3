Feature: Test
#Scenario 1
  #Scenario Outline: Allowing and redirecting user according to its access
   # Given The unauthenticated GoHeavy User is in the Login view
    #When User insert email "<emails>" and password "<passwords>"
    #And User clicks on the "Sign in" button
    #Then The system allows the user access to the system
    #And Sytem redirects to "<views>" view

    #Examples: 
    #  | emails             | passwords | views             |
    #  | novanick@gmail.com | @User123  | Dashboard         |
    #  | evakings@gmail.com | @User123  | Drivers List      |
    #  | piper95@gmail.com  | @User123  | Fleet Owners List |

#Scenario 2
  #Scenario Outline: Validation fields
   # Given The unauthenticated GoHeavy User is in the Login view
   # When User insert email "<emails>" and password "<passwords>"
   # And User clicks on the "Sign in" button
   #Then The system displays an error message  "<messages>"

   # Examples: 
   #  | emails             | passwords | messages                 |
   # | novanick@gmail.com |           | This field is required   |
   #   |                    | @User123  | This field is required   |
   #   |                    |           | This field is required   |
 
 #Scenario 3
 #  Scenario Outline: Loging fail Error messages
 #   Given The unauthenticated GoHeavy User is in the Login view
 #   When User insert email "<emails>" and password "<passwords>"
 #   And User clicks on the "Sign in" button
 #   Then The system displays an error message in popup windows 

 #   Examples: 
 #    | emails             | passwords        |
 #     | fail@gmail.com     |   @User123       | 
 #    | novanick@gmail.com | @failUser123     |
   
  #Scenario 4
   Scenario Outline: Loging fail Error messages
    Given The unauthenticated GoHeavy User is in the Login view
    When User insert email "<emails>" and password "<passwords>"
    Then The system displays an error message  "<messages>" 
    

    Examples: 
    | emails             | passwords        |messages|
    | fail@gmail.com     |   @User123       | Please, enter a valid email address.|
    | novanick@gmail.com | @failUser123     | Please, enter a valid email address.|