# Lend-Borrow-Plan-Generator
In order to inform borrowers about the final repayment schedule, we need to have pre-calculated repayment plans throughout the lifetime of a loan.

# How to run
    1- Clone the project from the link:
        https://github.com/ahmad3ttallah/Lend-Borrow-Plan-Generator.git
    2- Open it into your prefered IDE "Eclipse for example".
    3- Maven build.
    4- Run as Java application.

    Now you have a running web service that calculates the plan of borrowing some money with interest rate [yearly]
    
# How to test
    1- Install POST MAN web services test tool, you can find it from:
        https://www.getpostman.com/
    2- Call the web service:
        http://localhost:8080/generate-plan
        METHOD: POST
        Body:   {
                  "loanAmount": 5000,
                  "nominalRate": "5",
                  "duration": 24,
                  "startDate": "2018-01-01T00:00:01Z"
                } 
        Expected result should be:
              {
                  "plan": [
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-01-01T00:00:01Z",
                          "initialOutstandingPrincipal": 5000,
                          "interest": 20.83,
                          "principal": 198.53,
                          "remainingOutstandingPrincipal": 4801.47
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-02-01T00:00:01Z",
                          "initialOutstandingPrincipal": 4801.47,
                          "interest": 20.01,
                          "principal": 199.35,
                          "remainingOutstandingPrincipal": 4602.12
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-03-01T00:00:01Z",
                          "initialOutstandingPrincipal": 4602.12,
                          "interest": 19.18,
                          "principal": 200.18,
                          "remainingOutstandingPrincipal": 4401.93
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-04-01T00:00:01Z",
                          "initialOutstandingPrincipal": 4401.93,
                          "interest": 18.34,
                          "principal": 201.02,
                          "remainingOutstandingPrincipal": 4200.92
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-05-01T00:00:01Z",
                          "initialOutstandingPrincipal": 4200.92,
                          "interest": 17.5,
                          "principal": 201.86,
                          "remainingOutstandingPrincipal": 3999.06
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-06-01T00:00:01Z",
                          "initialOutstandingPrincipal": 3999.06,
                          "interest": 16.66,
                          "principal": 202.7,
                          "remainingOutstandingPrincipal": 3796.36
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-07-01T00:00:01Z",
                          "initialOutstandingPrincipal": 3796.36,
                          "interest": 15.82,
                          "principal": 203.54,
                          "remainingOutstandingPrincipal": 3592.82
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-08-01T00:00:01Z",
                          "initialOutstandingPrincipal": 3592.82,
                          "interest": 14.97,
                          "principal": 204.39,
                          "remainingOutstandingPrincipal": 3388.43
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-09-01T00:00:01Z",
                          "initialOutstandingPrincipal": 3388.43,
                          "interest": 14.12,
                          "principal": 205.24,
                          "remainingOutstandingPrincipal": 3183.19
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-10-01T00:00:01Z",
                          "initialOutstandingPrincipal": 3183.19,
                          "interest": 13.26,
                          "principal": 206.1,
                          "remainingOutstandingPrincipal": 2977.09
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-11-01T00:00:01Z",
                          "initialOutstandingPrincipal": 2977.09,
                          "interest": 12.4,
                          "principal": 206.96,
                          "remainingOutstandingPrincipal": 2770.14
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2018-12-01T00:00:01Z",
                          "initialOutstandingPrincipal": 2770.14,
                          "interest": 11.54,
                          "principal": 207.82,
                          "remainingOutstandingPrincipal": 2562.32
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2019-01-01T00:00:01Z",
                          "initialOutstandingPrincipal": 2562.32,
                          "interest": 10.68,
                          "principal": 208.68,
                          "remainingOutstandingPrincipal": 2353.64
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2019-02-01T00:00:01Z",
                          "initialOutstandingPrincipal": 2353.64,
                          "interest": 9.81,
                          "principal": 209.55,
                          "remainingOutstandingPrincipal": 2144.08
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2019-03-01T00:00:01Z",
                          "initialOutstandingPrincipal": 2144.08,
                          "interest": 8.93,
                          "principal": 210.43,
                          "remainingOutstandingPrincipal": 1933.66
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2019-04-01T00:00:01Z",
                          "initialOutstandingPrincipal": 1933.66,
                          "interest": 8.06,
                          "principal": 211.3,
                          "remainingOutstandingPrincipal": 1722.35
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2019-05-01T00:00:01Z",
                          "initialOutstandingPrincipal": 1722.35,
                          "interest": 7.18,
                          "principal": 212.18,
                          "remainingOutstandingPrincipal": 1510.17
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2019-06-01T00:00:01Z",
                          "initialOutstandingPrincipal": 1510.17,
                          "interest": 6.29,
                          "principal": 213.07,
                          "remainingOutstandingPrincipal": 1297.1
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2019-07-01T00:00:01Z",
                          "initialOutstandingPrincipal": 1297.1,
                          "interest": 5.4,
                          "principal": 213.96,
                          "remainingOutstandingPrincipal": 1083.15
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2019-08-01T00:00:01Z",
                          "initialOutstandingPrincipal": 1083.15,
                          "interest": 4.51,
                          "principal": 214.85,
                          "remainingOutstandingPrincipal": 868.3
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2019-09-01T00:00:01Z",
                          "initialOutstandingPrincipal": 868.3,
                          "interest": 3.62,
                          "principal": 215.74,
                          "remainingOutstandingPrincipal": 652.56
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2019-10-01T00:00:01Z",
                          "initialOutstandingPrincipal": 652.56,
                          "interest": 2.72,
                          "principal": 216.64,
                          "remainingOutstandingPrincipal": 435.92
                      },
                      {
                          "borrowerPaymentAmount": 219.36,
                          "date": "2019-11-01T00:00:01Z",
                          "initialOutstandingPrincipal": 435.92,
                          "interest": 1.82,
                          "principal": 217.54,
                          "remainingOutstandingPrincipal": 218.37
                      },
                      {
                          "borrowerPaymentAmount": 219.28,
                          "date": "2019-12-01T00:00:01Z",
                          "initialOutstandingPrincipal": 218.37,
                          "interest": 0.91,
                          "principal": 218.37,
                          "remainingOutstandingPrincipal": 0
                      }
                  ]
              }
