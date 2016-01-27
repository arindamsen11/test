$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Ios_Poc.feature");
formatter.feature({
  "line": 1,
  "name": "Ios_Poc",
  "description": "",
  "id": "ios-poc",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 25,
  "name": "Simulator",
  "description": "",
  "id": "ios-poc;simulator",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@Test3"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "Launch Url and Sign in",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "Select Flight Details and Continue",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "Select Flights and Continue",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "Fill passenger details and book flight",
  "keyword": "Then "
});
formatter.match({
  "location": "Test3_New.launch_Url_and_Sign_in()"
});
formatter.result({
  "duration": 75618142114,
  "status": "passed"
});
formatter.match({
  "location": "Test3_New.select_Flight_Details_and_Continue()"
});
formatter.result({
  "duration": 7098737535,
  "status": "passed"
});
formatter.match({
  "location": "Test3_New.select_Flights_and_Continue()"
});
formatter.result({
  "duration": 8210503283,
  "status": "passed"
});
formatter.match({
  "location": "Test3_New.fill_passenger_details_and_book_flight()"
});
formatter.result({
  "duration": 20160047393,
  "status": "passed"
});
});