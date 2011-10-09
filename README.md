Rand57
========

### Problem:
Given a function which produces a random integer in the range [1,5], write a function which produces a random integer in the range [1,7].
(values distribution is uniform)

### Solution:
I've implemented three solutions, while rand7_3 gives the best results requiring ~2 x rand5 executions per call:

### Results
Below are the results from my DualCore MacBookPro using scala 2.9.1:

* Function:----Time-:-------------Values Distribution----------------- 
* rand5   :   92ms  : 200291,200283,199117,199634,200675
* rand7_1 :  346ms  : 142762,143179,143385,142716,143164,142550,142244
* rand7_2 :  229ms  : 143050,142782,142518,142653,142286,143306,143405
* rand7_3 :  136ms  : 143104,143155,142185,142884,143143,142396,143133
