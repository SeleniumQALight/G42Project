
Narrative:
As User
I want to enter login and pass
So I will LogIn

Scenario: TC-01 Unvalide LogIn On V3
Given User is on the V3 login page
When User enter '<login>' to loginInput on Login Page
And User enter '<passWord>' to passWordInput on Login Page
And User click button Enter
Then User sees loginForm on LoginPage
Examples:
| login | passWord |
| ent   | 909090   |
|       | 909090   |

Scenario: TC-02 Valid LogIn On V3
Given User is on the V3 login page
When User enter 'Student' to loginInput on Login Page
And User enter '909090' to passWordInput on Login Page
And User click button Enter
Then User sees avatar on Home page





