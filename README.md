Rand57
========

### Problem:
Given a function which produces a random integer in the range [1,5], write a function which produces a random integer in the range [1,7].
(values distribution is uniform)

### Solution:
I've implemented several solutions, while rand7_4 gives the best results so far. It requires 2 x rand5 executions per call with probability of 21/25.

### Results
Below are the results from my i5-2.8/8Gb using scala 2.9.1 for 10,000,000 iterations:

* Function:----Time-:-------------Values Distribution----------------- 
* rand5---:-443ms--:-2001116,1998263,2000685,1999141,2000795
* rand7_1-:-1840ms-:-1427723,1428514,1428543,1427846,1428484,1428560,1430330
* rand7_2-:-1626ms-:-1428740,1426705,1429652,1428907,1429705,1426454,1429837
* rand7_3-:-789ms--:-1427602,1428453,1428401,1428955,1427490,1429370,1429729
* rand7_4-:-647ms--:-1428140,1428780,1428737,1427564,1428554,1428252,1429973
