$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/AccountList.feature");
formatter.feature({
  "line": 1,
  "name": "Account List",
  "description": "\nAs a: CM App User\nI Want: To be able to add my bank accounts\nSo That: I can view all my account information",
  "id": "account-list",
  "keyword": "Feature"
});
formatter.before({
  "duration": 9429540,
  "status": "passed"
});
formatter.background({
  "line": 7,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 8,
  "name": "I am on login screen",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginScreenStep.iAmOnLoginScreen()"
});
formatter.result({
  "duration": 10631794122,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Accounts Displayed",
  "description": "",
  "id": "account-list;accounts-displayed",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@accountList"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I login with valid credentials",
  "rows": [
    {
      "cells": [
        "Username",
        "MemorableAnswer",
        "Password"
      ],
      "line": 13
    },
    {
      "cells": [
        "IB1120293731",
        "FooBar",
        "FooBar12"
      ],
      "line": 14
    }
  ],
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 15,
      "value": "#    And I tap include my bank button"
    },
    {
      "line": 16,
      "value": "#    And I tap \"HSBC\" bank"
    },
    {
      "line": 17,
      "value": "#    When I login with valid credentials"
    },
    {
      "line": 18,
      "value": "#      |Username           |MemorableAnswer|Password|"
    },
    {
      "line": 19,
      "value": "#      |IB1120293731       |FooBar         |FooBar12|"
    },
    {
      "line": 20,
      "value": "#    And I am on polling screen"
    },
    {
      "line": 21,
      "value": "#    And Accounts have successfully been added"
    },
    {
      "line": 22,
      "value": "#    And I am on you screen"
    }
  ],
  "line": 23,
  "name": "I set my passcode",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I disable push notifications",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "I am on you screen",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I scroll to bottom of screen",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I should see LOY ISA PREM account with balance £1511.84",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "I should see MORTGAGE account with balance − £60,2671.69",
  "keyword": "And "
});
formatter.match({
  "location": "LoginScreenStep.iLoginWithInvalidCredentials(DataTable)"
});
formatter.result({
  "duration": 13221509268,
  "status": "passed"
});
formatter.match({
  "location": "PermissionsScreenStep.iEnterPasscode()"
});
formatter.result({
  "duration": 23047386034,
  "status": "passed"
});
formatter.match({
  "location": "PermissionsScreenStep.iDisablePushNotifications()"
});
formatter.result({
  "duration": 1123943501,
  "status": "passed"
});
formatter.match({
  "location": "YouScreenStep.iAmOnYouscreen()"
});
formatter.result({
  "duration": 763522244,
  "status": "passed"
});
formatter.match({
  "location": "YouScreenStep.iScrollToBottomOfScreen()"
});
formatter.result({
  "duration": 7151131163,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LOY ISA PREM",
      "offset": 13
    },
    {
      "val": "£1511.84",
      "offset": 47
    }
  ],
  "location": "YouScreenStep.iShouldSeeLOYISAPREMAccountWithBalance(String,String)"
});
formatter.result({
  "duration": 1516812637,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "MORTGAGE",
      "offset": 13
    },
    {
      "val": "− £60,2671.69",
      "offset": 43
    }
  ],
  "location": "YouScreenStep.iShouldSeeLOYISAPREMAccountWithBalance(String,String)"
});
formatter.result({
  "duration": 1532074167,
  "status": "passed"
});
formatter.after({
  "duration": 115507,
  "status": "passed"
});
});