# mp1 Feedback

## Grade: D

| Compilation | Timeout | Duration |
|:-----------:|:-------:|:--------:|
|Yes|No|109.15|

## Comments
Definitely need to be more careful. Please reach out for help from the TAs or from instructors.
Specifications are generally acceptable, they are not very descriptive of the inputs and outputs, especially in tasks 1-3, the team should try to describe the whole input set (pre-conditions) and give more descriptive (post-conditions).  Few comments are used to describe methods and implementations. There are places where comments seem to be useful in interpretation however code is mostly self-explanatory.  Code style is generally bad. Spacing between lines is inconsistent or too close to each other, lines often are much greater than 80 characters. Their code style negatively affects the readability of the code. Task 1-3 style is okay however other tasks are poor.
## Test Results 
### cpen221.mp1.Task1ATests
| Test Status | Count |
| ----------- | ----- |
|tests|5|
|skipped|0|
|failures|5|
|errors|0|
#### Failed Tests
1. `[1] resources/Gettysburg.txt, Gettysburg Address, 26.6, 0.1 (org.opentest4j.AssertionFailedError: expected: <26.6> but was: <52.2>)`
1. `[2] resources/Kennedy.txt, Kennedy on the Cuban Missile Crisis, 29.71, 0.1 (org.opentest4j.AssertionFailedError: expected: <29.71> but was: <44.629629629629626>)`
1. `testEmptyDocument() (java.lang.StringIndexOutOfBoundsException: String index out of range: 0)`
1. `[1] resources/Gettysburg.txt, Gettysburg Address, 2.1, 0.1 (org.opentest4j.AssertionFailedError: expected: <2.1> but was: <3.2>)`
1. `[2] resources/Kennedy.txt, Kennedy on the Cuban Missile Crisis, 2.74, 0.1 (org.opentest4j.AssertionFailedError: expected: <2.74> but was: <3.6481481481481484>)`
### cpen221.mp1.Task2ATests
| Test Status | Count |
| ----------- | ----- |
|tests|7|
|skipped|0|
|failures|1|
|errors|0|
#### Failed Tests
1. `testEmptyDocument() (java.lang.StringIndexOutOfBoundsException: String index out of range: 0)`
### cpen221.mp1.Task3ATests
| Test Status | Count |
| ----------- | ----- |
|tests|4|
|skipped|0|
|failures|4|
|errors|0|
#### Failed Tests
1. `[1] resources/Gettysburg.txt, Gettysburg Address, It is altogether fitting and proper that we should do this, But in a larger sense, we cannot dedicate, we cannot consecrate, we cannot hallow this ground (org.opentest4j.AssertionFailedError: expected: <It is altogether fitting and proper that we should do this> but was: <we are met on a great battlefield of that war.we have come to dedicate a portion of that field as a final resting-place for those who here gave their lives that that nation might live>)`
1. `[2] resources/EmmaWatson.txt, Emma Watson at the UN, Thank you very, very much, Sadly, many of the things that she wanted to change are still true today (org.opentest4j.AssertionFailedError: expected: <Thank you very, very much> but was: <thank you very, very much>)`
1. `[3] resources/Malala.txt, Malala Yousafzai at the UN, We will continue our journey to our destination of peace and education for everyone, They think that God is a tiny, little conservative being who would send girls to the hell just because of going to school (org.opentest4j.AssertionFailedError: expected: <We will continue our journey to our destination of peace and education for everyone> but was: <we will continue our journey to our destination of peace and education for everyone>)`
1. `[4] resources/Kennedy.txt, Kennedy on the Cuban Missile Crisis, Thank you and good night, But this country has no wish to cause you to suffer or to impose any system upon you (org.opentest4j.AssertionFailedError: expected: <Thank you and good night> but was: <god willing, that goal will be achieved.thank you and good night>)`
### cpen221.mp1.Task4ATests
| Test Status | Count |
| ----------- | ----- |
|tests|7|
|skipped|0|
|failures|6|
|errors|0|
#### Failed Tests
1. `[1] cpen221.mp1.Document@31c269fd, cpen221.mp1.Document@372b0d86, 46.97, 0.5 (org.opentest4j.AssertionFailedError: expected: <46.97> but was: <59.928288420916374>)`
1. `[2] cpen221.mp1.Document@31c269fd, cpen221.mp1.Document@3d9fc57a, 23.37, 0.5 (org.opentest4j.AssertionFailedError: expected: <23.37> but was: <29.84819741356481>)`
1. `[3] cpen221.mp1.Document@3d9fc57a, cpen221.mp1.Document@31c269fd, 23.37, 0.5 (org.opentest4j.AssertionFailedError: expected: <23.37> but was: <29.84819741356481>)`
1. `[5] cpen221.mp1.Document@5bbbdd4b, cpen221.mp1.Document@31c269fd, 48.57, 0.4 (org.opentest4j.AssertionFailedError: expected: <48.57> but was: <72.83460907535328>)`
1. `[6] cpen221.mp1.Document@372b0d86, null, 99.94, 0.5 (java.lang.NullPointerException: Cannot invoke "cpen221.mp1.Document.averageSentenceLength()" because "doc" is null)`
1. `[7] null, null, 0.0, 0.05 (java.lang.NullPointerException: Cannot invoke "cpen221.mp1.Document.averageSentenceLength()" because "doc" is null)`
### cpen221.mp1.Task5ATests
| Test Status | Count |
| ----------- | ----- |
|tests|1|
|skipped|0|
|failures|1|
|errors|0|
#### Failed Tests
1. `initializationError (java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "pe" is null)`
### cpen221.mp1.Task6CTests
| Test Status | Count |
| ----------- | ----- |
|tests|3|
|skipped|0|
|failures|3|
|errors|0|
#### Failed Tests
1. `[1] cpen221.mp1.Document@213e3629, 32, 8, 16, [95, 127, 111, 97, 109, 28, 20, 105, 127, 48, 116, 115, 20, 81, 98, 31, 115, 127, 121, 111, 105, 98, 20, 101, 122, 130, 43, 109, 89, 16, 104, 110] (org.opentest4j.AssertionFailedError: array contents differ at index [0], expected: <95> but was: <127>)`
1. `[2] cpen221.mp1.Document@3d9fc57a, 32, 8, 16, [81, 127, 128, 114, 103, 83, 99, 114, 112, 48, 108, 110, 88, 16, 103, 100, 129, 117, 121, 32, 109, 85, 85, 113, 126, 48, 108, 103, 99, 16, 99, 116] (org.opentest4j.AssertionFailedError: array contents differ at index [0], expected: <81> but was: <113>)`
1. `testDecryption() (java.lang.StringIndexOutOfBoundsException: start 0, end 8000, length 7925)`
### cpen221.mp1.Task6DTests
| Test Status | Count |
| ----------- | ----- |
|tests|9|
|skipped|0|
|failures|1|
|errors|0|
#### Failed Tests
1. `[8] BABABBCABBCABACBBBABABCACBBBABACBCBBAABBACBACBBACABBBBAACABBBCACABBBBAACABBBACBBCAABCBBABCBAABBCBBBABCBABABCCBBABBACAABBBACACBBB, ABBAC, BABCB, true (org.opentest4j.AssertionFailedError: expected: <true> but was: <false>)`
### cpen221.mp1.Task6ATests
| Test Status | Count |
| ----------- | ----- |
|tests|12|
|skipped|0|
|failures|0|
|errors|0|
### cpen221.mp1.Task6BTests
| Test Status | Count |
| ----------- | ----- |
|tests|4|
|skipped|0|
|failures|0|
|errors|0|

## Code Quality
```
Document.java:13:	Possible God Class (WMC=59, ATFD=24, TCC=9.048%)
Document.java:13:	This class has too many methods, consider refactoring it.
Document.java:18:	Found non-transient, non-static member. Please mark as transient or provide accessors.
Document.java:19:	Found non-transient, non-static member. Please mark as transient or provide accessors.
Document.java:20:	Found non-transient, non-static member. Please mark as transient or provide accessors.
Document.java:21:	Found non-transient, non-static member. Please mark as transient or provide accessors.
Document.java:21:	Private field 'docWords' could be made final; it is only initialized in the declaration or constructor.
Document.java:22:	Avoid using implementation types like 'TreeMap'; use the interface instead
Document.java:22:	Found non-transient, non-static member. Please mark as transient or provide accessors.
Document.java:22:	Private field 'catalogueWords' could be made final; it is only initialized in the declaration or constructor.
Document.java:23:	Found non-transient, non-static member. Please mark as transient or provide accessors.
Document.java:24:	Found non-transient, non-static member. Please mark as transient or provide accessors.
Document.java:25:	Found non-transient, non-static member. Please mark as transient or provide accessors.
Document.java:27:	Found non-transient, non-static member. Please mark as transient or provide accessors.
Document.java:27:	This final field could be made static
Document.java:28:	Found non-transient, non-static member. Please mark as transient or provide accessors.
Document.java:28:	This final field could be made static
Document.java:46:	Ensure that resources like this Scanner object are closed after use
Document.java:55:	System.out.println is used
Document.java:60:	When doing a String.toLowerCase()/toUpperCase() call, use a Locale
Document.java:79:	Ensure that resources like this FileReader object are closed after use
Document.java:83:	These nested if statements could be combined
Document.java:84:	Avoid reassigning the loop control variable 'fileLine'
Document.java:93:	System.out.println is used
Document.java:98:	When doing a String.toLowerCase()/toUpperCase() call, use a Locale
Document.java:109:	Avoid reassigning parameters such as 'line'
Document.java:111:	These nested if statements could be combined
Document.java:129:	Found 'DD'-anomaly for variable 'start' (lines '129'-'131').
Document.java:129:	Found 'DU'-anomaly for variable 'start' (lines '129'-'144').
Document.java:131:	Found 'DD'-anomaly for variable 'start' (lines '131'-'131').
Document.java:131:	Found 'DU'-anomaly for variable 'start' (lines '131'-'144').
Document.java:134:	When doing a String.toLowerCase()/toUpperCase() call, use a Locale
Document.java:157:	Found 'DD'-anomaly for variable 'start' (lines '157'-'162').
Document.java:157:	Found 'DU'-anomaly for variable 'start' (lines '157'-'182').
Document.java:162:	Found 'DD'-anomaly for variable 'start' (lines '162'-'162').
Document.java:162:	Found 'DU'-anomaly for variable 'start' (lines '162'-'182').
Document.java:167:	Avoid using Literals in Conditional Statements
Document.java:167:	Use equals() to compare strings instead of '==' or '!='
Document.java:175:	Found 'DD'-anomaly for variable 'arrayOfWords' (lines '175'-'178').
Document.java:178:	Found 'DD'-anomaly for variable 'arrayOfWords' (lines '178'-'178').
Document.java:193:	Avoid using Literals in Conditional Statements
Document.java:193:	Potential violation of Law of Demeter (object not created locally)
Document.java:197:	Potential violation of Law of Demeter (object not created locally)
Document.java:197:	Potential violation of Law of Demeter (object not created locally)
Document.java:198:	Potential violation of Law of Demeter (object not created locally)
Document.java:198:	Potential violation of Law of Demeter (object not created locally)
Document.java:199:	Potential violation of Law of Demeter (object not created locally)
Document.java:199:	Potential violation of Law of Demeter (object not created locally)
Document.java:200:	Potential violation of Law of Demeter (object not created locally)
Document.java:200:	Potential violation of Law of Demeter (object not created locally)
Document.java:217:	Potential violation of Law of Demeter (object not created locally)
Document.java:219:	Potential violation of Law of Demeter (object not created locally)
Document.java:222:	Potential violation of Law of Demeter (object not created locally)
Document.java:222:	Potential violation of Law of Demeter (object not created locally)
Document.java:237:	This for loop can be replaced by a foreach loop
Document.java:278:	Found 'DD'-anomaly for variable 'count' (lines '278'-'281').
Document.java:281:	Avoid using Literals in Conditional Statements
Document.java:281:	Found 'DD'-anomaly for variable 'count' (lines '281'-'281').
Document.java:305:	This for loop can be replaced by a foreach loop
Document.java:370:	This for loop can be replaced by a foreach loop
Document.java:383:	Found 'DD'-anomaly for variable 'count' (lines '383'-'387').
Document.java:387:	Found 'DD'-anomaly for variable 'count' (lines '387'-'387').
ComplexNumber.java:9:	Field re has the same name as a method
ComplexNumber.java:9:	Found non-transient, non-static member. Please mark as transient or provide accessors.
ComplexNumber.java:10:	Field im has the same name as a method
ComplexNumber.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
ComplexNumber.java:84:	Potential violation of Law of Demeter (object not created locally)
ComplexNumber.java:84:	Potential violation of Law of Demeter (object not created locally)
Cryptography.java:12:	All methods are static.  Consider using a utility class instead. Alternatively, you could add a private constructor or make the class abstract to silence this warning.
Cryptography.java:37:	Found 'DD'-anomaly for variable 'encrypted' (lines '37'-'40').
Cryptography.java:38:	Found 'DU'-anomaly for variable 'encryptSeq' (lines '38'-'43').
Cryptography.java:40:	Found 'DD'-anomaly for variable 'encrypted' (lines '40'-'40').
Cryptography.java:54:	Potential violation of Law of Demeter (object not created locally)
Cryptography.java:62:	Potential violation of Law of Demeter (method chain calls)
Cryptography.java:84:	Consider using varargs for methods or constructors which take an array the last parameter.
Cryptography.java:85:	Found 'DD'-anomaly for variable 'output' (lines '85'-'111').
Cryptography.java:88:	Found 'DD'-anomaly for variable 'freq' (lines '88'-'92').
Cryptography.java:92:	Found 'DD'-anomaly for variable 'freq' (lines '92'-'92').
Cryptography.java:97:	Avoid using Literals in Conditional Statements
Cryptography.java:98:	Found 'DU'-anomaly for variable 'amp' (lines '98'-'114').
Cryptography.java:101:	Found 'DU'-anomaly for variable 'amp' (lines '101'-'114').
Cryptography.java:104:	Found 'DU'-anomaly for variable 'amp' (lines '104'-'114').
Cryptography.java:106:	Found 'DU'-anomaly for variable 'amp' (lines '106'-'114').
Cryptography.java:108:	Found 'DU'-anomaly for variable 'period' (lines '108'-'114').
Cryptography.java:111:	Found 'DD'-anomaly for variable 'output' (lines '111'-'111').
DFT.java:8:	All methods are static.  Consider using a utility class instead. Alternatively, you could add a private constructor or make the class abstract to silence this warning.
DFT.java:15:	Consider using varargs for methods or constructors which take an array the last parameter.
DFT.java:17:	Found 'DU'-anomaly for variable 'N' (lines '17'-'27').
DFT.java:34:	Consider using varargs for methods or constructors which take an array the last parameter.
DFT.java:35:	Found 'DD'-anomaly for variable 'inSignalComplex' (lines '35'-'37').
DFT.java:37:	Found 'DD'-anomaly for variable 'inSignalComplex' (lines '37'-'37').
Untangler.java:10:	All methods are static.  Consider using a utility class instead. Alternatively, you could add a private constructor or make the class abstract to silence this warning.
Untangler.java:25:	The method 'areTangled(String, String, String)' has a cyclomatic complexity of 11.
Untangler.java:27:	Found 'DU'-anomaly for variable 'src1List' (lines '27'-'63').
Untangler.java:28:	Found 'DU'-anomaly for variable 'src2List' (lines '28'-'63').
Untangler.java:29:	Found 'DU'-anomaly for variable 'j' (lines '29'-'63').
Untangler.java:30:	Found 'DU'-anomaly for variable 'k' (lines '30'-'63').
Untangler.java:32:	Potential violation of Law of Demeter (method chain calls)
Untangler.java:32:	Potential violation of Law of Demeter (method chain calls)
Untangler.java:35:	Avoid reassigning the loop control variable 'i'
Untangler.java:35:	Found 'DD'-anomaly for variable 'i' (lines '35'-'31').
Untangler.java:36:	Found 'DU'-anomaly for variable 'j' (lines '36'-'63').
Untangler.java:38:	Potential violation of Law of Demeter (method chain calls)
Untangler.java:38:	Potential violation of Law of Demeter (method chain calls)
Untangler.java:41:	Avoid reassigning the loop control variable 'i'
Untangler.java:41:	Found 'DD'-anomaly for variable 'i' (lines '41'-'31').
Untangler.java:42:	Found 'DU'-anomaly for variable 'k' (lines '42'-'63').
Untangler.java:45:	Potential violation of Law of Demeter (method chain calls)
Untangler.java:45:	Potential violation of Law of Demeter (method chain calls)
Untangler.java:47:	Avoid reassigning the loop control variable 'i'
Untangler.java:47:	Found 'DD'-anomaly for variable 'i' (lines '47'-'31').
Untangler.java:47:	Found 'DU'-anomaly for variable 'i' (lines '47'-'63').
Untangler.java:51:	Found 'DU'-anomaly for variable 'j' (lines '51'-'63').
Untangler.java:56:	Found 'DU'-anomaly for variable 'k' (lines '56'-'63').
Untangler.java:62:	Potential violation of Law of Demeter (object not created locally)
Untangler.java:62:	Substitute calls to size() == 0 (or size() != 0, size() > 0, size() < 1) with calls to isEmpty()
Untangler.java:71:	Avoid using implementation types like 'ArrayList'; use the interface instead
NoSuitableSentenceException.java:3:	Classes implementing Serializable should set a serialVersionUID
NotFoundException.java:3:	Classes implementing Serializable should set a serialVersionUID
SentenceAnalysis.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
SentenceAnalysis.java:10:	Private field 'sentence' could be made final; it is only initialized in the declaration or constructor.
SentenceAnalysis.java:11:	Found non-transient, non-static member. Please mark as transient or provide accessors.
SentenceAnalysis.java:11:	Private field 'analysis' could be made final; it is only initialized in the declaration or constructor.
SentimentAnalysis.java:3:	Avoid unused imports such as 'com.google.cloud.language.v1'
SentimentAnalysis.java:14:	All methods are static.  Consider using a utility class instead. Alternatively, you could add a private constructor or make the class abstract to silence this warning.
SentimentAnalysis.java:24:	Potential violation of Law of Demeter (object not created locally)
SentimentAnalysis.java:26:	Potential violation of Law of Demeter (method chain calls)
SentimentAnalysis.java:26:	Potential violation of Law of Demeter (method chain calls)
SentimentAnalysis.java:30:	Avoid using Literals in Conditional Statements
SentimentAnalysis.java:30:	Potential violation of Law of Demeter (method chain calls)
SentimentAnalysis.java:30:	Potential violation of Law of Demeter (object not created locally)
SentimentAnalysis.java:31:	Potential violation of Law of Demeter (object not created locally)
SentimentAnalysis.java:43:	Potential violation of Law of Demeter (object not created locally)
SentimentAnalysis.java:45:	Potential violation of Law of Demeter (method chain calls)
SentimentAnalysis.java:45:	Potential violation of Law of Demeter (method chain calls)
SentimentAnalysis.java:49:	Potential violation of Law of Demeter (method chain calls)
SentimentAnalysis.java:49:	Potential violation of Law of Demeter (object not created locally)
SentimentAnalysis.java:50:	Potential violation of Law of Demeter (object not created locally)
SentimentAnalysis.java:61:	Found 'DU'-anomaly for variable 'sentence' (lines '61'-'74').
SentimentAnalysis.java:64:	Potential violation of Law of Demeter (object not created locally)
SentimentAnalysis.java:66:	Potential violation of Law of Demeter (object not created locally)
SentimentAnalysis.java:71:	System.out.println is used
SentimentAnalysis.java:72:	Avoid throwing raw exception types.
SentimentAnalysis.java:72:	New exception is thrown in catch block, original stack trace may be lost
DocumentSimilarity.java:8:	This class has too many methods, consider refactoring it.
DocumentSimilarity.java:11:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:11:	This final field could be made static
DocumentSimilarity.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:12:	This final field could be made static
DocumentSimilarity.java:13:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:13:	This final field could be made static
DocumentSimilarity.java:14:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:14:	This final field could be made static
DocumentSimilarity.java:15:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:15:	This final field could be made static
DocumentSimilarity.java:16:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:16:	This final field could be made static
DocumentSimilarity.java:19:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:19:	Private field 'allWords' could be made final; it is only initialized in the declaration or constructor.
DocumentSimilarity.java:20:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:20:	This final field could be made static
DocumentSimilarity.java:21:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:23:	Avoid using implementation types like 'HashMap'; use the interface instead
DocumentSimilarity.java:23:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:23:	Private field 'wordCounts' could be made final; it is only initialized in the declaration or constructor.
DocumentSimilarity.java:24:	Avoid using implementation types like 'HashMap'; use the interface instead
DocumentSimilarity.java:24:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:24:	Private field 'docWords' could be made final; it is only initialized in the declaration or constructor.
DocumentSimilarity.java:25:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:25:	Perhaps 'doc1Words' could be replaced by a local variable.
DocumentSimilarity.java:26:	Found non-transient, non-static member. Please mark as transient or provide accessors.
DocumentSimilarity.java:26:	Perhaps 'doc2Words' could be replaced by a local variable.
DocumentSimilarity.java:42:	Found 'DD'-anomaly for variable 'div_p' (lines '42'-'50').
DocumentSimilarity.java:42:	Found 'DD'-anomaly for variable 'div_q' (lines '42'-'51').
DocumentSimilarity.java:42:	Found 'DD'-anomaly for variable 'm_i' (lines '42'-'48').
DocumentSimilarity.java:42:	Found 'DD'-anomaly for variable 'p_i' (lines '42'-'46').
DocumentSimilarity.java:42:	Found 'DD'-anomaly for variable 'q_i' (lines '42'-'47').
DocumentSimilarity.java:42:	Found 'DU'-anomaly for variable 'div_p' (lines '42'-'57').
DocumentSimilarity.java:42:	Found 'DU'-anomaly for variable 'div_q' (lines '42'-'57').
DocumentSimilarity.java:42:	Found 'DU'-anomaly for variable 'm_i' (lines '42'-'57').
DocumentSimilarity.java:42:	Found 'DU'-anomaly for variable 'p_i' (lines '42'-'57').
DocumentSimilarity.java:42:	Found 'DU'-anomaly for variable 'q_i' (lines '42'-'57').
DocumentSimilarity.java:42:	Use one line for each declaration, it enhances code readability.
DocumentSimilarity.java:71:	Found 'DU'-anomaly for variable 'weights' (lines '71'-'93').
DocumentSimilarity.java:74:	Found 'DU'-anomaly for variable 'doc1_metrics' (lines '74'-'93').
DocumentSimilarity.java:75:	Found 'DU'-anomaly for variable 'doc2_metrics' (lines '75'-'93').
DocumentSimilarity.java:119:	Potential violation of Law of Demeter (method chain calls)
DocumentSimilarity.java:120:	Potential violation of Law of Demeter (method chain calls)
DocumentSimilarity.java:172:	Found 'DD'-anomaly for variable 'start' (lines '172'-'177').
DocumentSimilarity.java:172:	Found 'DU'-anomaly for variable 'start' (lines '172'-'197').
DocumentSimilarity.java:177:	Found 'DD'-anomaly for variable 'start' (lines '177'-'177').
DocumentSimilarity.java:177:	Found 'DU'-anomaly for variable 'start' (lines '177'-'197').
DocumentSimilarity.java:182:	Avoid using Literals in Conditional Statements
DocumentSimilarity.java:182:	Use equals() to compare strings instead of '==' or '!='
DocumentSimilarity.java:190:	Found 'DD'-anomaly for variable 'arrayOfWords' (lines '190'-'193').
DocumentSimilarity.java:193:	Found 'DD'-anomaly for variable 'arrayOfWords' (lines '193'-'193').
DocumentSimilarity.java:208:	Potential violation of Law of Demeter (object not created locally)
DocumentSimilarity.java:210:	Potential violation of Law of Demeter (object not created locally)
DocumentSimilarity.java:213:	Potential violation of Law of Demeter (object not created locally)
DocumentSimilarity.java:213:	Potential violation of Law of Demeter (object not created locally)
DocumentSimilarity.java:228:	This for loop can be replaced by a foreach loop
DocumentSimilarity.java:242:	Potential violation of Law of Demeter (method chain calls)
DocumentSimilarity.java:243:	Potential violation of Law of Demeter (method chain calls)
DocumentSimilarity.java:243:	Potential violation of Law of Demeter (method chain calls)
DocumentSimilarity.java:245:	Potential violation of Law of Demeter (method chain calls)
DocumentSimilarity.java:268:	Potential violation of Law of Demeter (method chain calls)
GroupingDocuments.java:11:	All methods are static.  Consider using a utility class instead. Alternatively, you could add a private constructor or make the class abstract to silence this warning.
GroupingDocuments.java:11:	The class 'GroupingDocuments' has a Modified Cyclomatic Complexity of 4 (Highest = 10).
GroupingDocuments.java:11:	The class 'GroupingDocuments' has a Standard Cyclomatic Complexity of 4 (Highest = 10).
GroupingDocuments.java:26:	The method 'groupBySimilarity' has a Modified Cyclomatic Complexity of 10.
GroupingDocuments.java:26:	The method 'groupBySimilarity' has a Standard Cyclomatic Complexity of 10.
GroupingDocuments.java:26:	The method 'groupBySimilarity(Set, int)' has a cyclomatic complexity of 10.
GroupingDocuments.java:27:	Found 'DD'-anomaly for variable 'returnGroups' (lines '27'-'80').
GroupingDocuments.java:27:	The initializer for variable 'returnGroups' is never used (overwritten on line 80)
GroupingDocuments.java:31:	Found 'DD'-anomaly for variable 'comparisons' (lines '31'-'46').
GroupingDocuments.java:31:	Found 'DU'-anomaly for variable 'comparisons' (lines '31'-'83').
GroupingDocuments.java:32:	Found 'DD'-anomaly for variable 'pair' (lines '32'-'59').
GroupingDocuments.java:32:	Found 'DU'-anomaly for variable 'pair' (lines '32'-'83').
GroupingDocuments.java:32:	The initializer for variable 'pair' is never used (overwritten on line 59)
GroupingDocuments.java:34:	Found 'DU'-anomaly for variable 'lowestNum' (lines '34'-'83').
GroupingDocuments.java:35:	Found 'DD'-anomaly for variable 'sameGroup' (lines '35'-'58').
GroupingDocuments.java:35:	Found 'DU'-anomaly for variable 'sameGroup' (lines '35'-'83').
GroupingDocuments.java:35:	The initializer for variable 'sameGroup' is never used (overwritten on line 58)
GroupingDocuments.java:37:	Found 'DU'-anomaly for variable 'docSim' (lines '37'-'83').
GroupingDocuments.java:46:	Found 'DD'-anomaly for variable 'comparisons' (lines '46'-'46').
GroupingDocuments.java:46:	Found 'DU'-anomaly for variable 'comparisons' (lines '46'-'83').
GroupingDocuments.java:58:	Found 'DD'-anomaly for variable 'sameGroup' (lines '58'-'62').
GroupingDocuments.java:65:	Avoid printStackTrace(); use a logger call instead.
GroupingDocuments.java:67:	Found 'DU'-anomaly for variable 'lowestNum' (lines '67'-'83').
GroupingDocuments.java:73:	Avoid catching generic exceptions such as NullPointerException, RuntimeException, Exception in try-catch block
GroupingDocuments.java:74:	System.out.println is used
GroupingDocuments.java:97:	Found 'DD'-anomaly for variable 'pairCopy' (lines '97'-'103').
GroupingDocuments.java:99:	Found 'DD'-anomaly for variable 'temp' (lines '99'-'118').
GroupingDocuments.java:103:	Found 'DD'-anomaly for variable 'pairCopy' (lines '103'-'103').
GroupingDocuments.java:111:	Found 'DD'-anomaly for variable 'smallest' (lines '111'-'112').
GroupingDocuments.java:112:	Found 'DD'-anomaly for variable 'smallest' (lines '112'-'113').
GroupingDocuments.java:118:	Found 'DD'-anomaly for variable 'temp' (lines '118'-'118').
GroupingDocuments.java:120:	Found 'DD'-anomaly for variable 'pairCopy' (lines '120'-'120').
GroupingDocuments.java:120:	Found 'DU'-anomaly for variable 'pairCopy' (lines '120'-'126').
GroupingDocuments.java:121:	Found 'DU'-anomaly for variable 'smallest' (lines '121'-'126').
GroupingDocuments.java:137:	Avoid using implementation types like 'ArrayList'; use the interface instead
GroupingDocuments.java:138:	Avoid unused local variables such as 'index'.
GroupingDocuments.java:138:	Found 'DU'-anomaly for variable 'index' (lines '138'-'148').
GroupingDocuments.java:157:	Avoid using implementation types like 'ArrayList'; use the interface instead
GroupingDocuments.java:158:	Found 'DD'-anomaly for variable 'indecies' (lines '158'-'163').
GroupingDocuments.java:158:	The initializer for variable 'indecies' is never used (overwritten on line 163)
GroupingDocuments.java:177:	Avoid using implementation types like 'ArrayList'; use the interface instead
GroupingDocuments.java:179:	This for loop can be replaced by a foreach loop
GroupingDocuments.java:194:	Found 'DD'-anomaly for variable 'ordered' (lines '194'-'196').
GroupingDocuments.java:194:	Found 'DD'-anomaly for variable 'ordered' (lines '194'-'200').
GroupingDocuments.java:196:	Found 'DD'-anomaly for variable 'ordered' (lines '196'-'197').
GroupingDocuments.java:200:	Found 'DD'-anomaly for variable 'ordered' (lines '200'-'201').
LoosePackageCoupling	-	No packages or classes specified
```

## Checkstyle Results
### `Document.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 6 |  | `Using the '.*' form of import should be avoided - java.io.*.` |
| 7 |  | `Using the '.*' form of import should be avoided - java.util.*.` |
| 25 |  | `Line is longer than 100 characters (found 116).` |
| 26 |  | `'array initialization' child has incorrect indentation level 13, expected level should be one of the following: 8, 41, 44.` |
| 26 | 93 | `',' is not followed by whitespace.` |
| 35 |  | `Line is longer than 100 characters (found 101).` |
| 68 |  | `Line is longer than 100 characters (found 101).` |
| 80 |  | `Line is longer than 100 characters (found 103).` |
| 83 |  | `Line is longer than 100 characters (found 143).` |
| 111 |  | `Line is longer than 100 characters (found 101).` |
| 123 | 43 | `Expected @param tag for 'content'.` |
| 131 |  | `Line is longer than 100 characters (found 104).` |
| 147 |  | `Line is longer than 100 characters (found 101).` |
| 158 | 27 | `'docWords' hides a field.` |
| 167 | 32 | `Literal Strings should be compared using equals(), not '!='.` |
| 185 |  | `Line is longer than 100 characters (found 103).` |
| 190 | 40 | `Expected @param tag for 'input'.` |
| 191 |  | `Line is longer than 100 characters (found 101).` |
| 197 | 62 | `'||' should be on a new line.` |
| 198 | 59 | `'||' should be on a new line.` |
| 199 | 59 | `'||' should be on a new line.` |
| 209 |  | `Line is longer than 100 characters (found 101).` |
| 281 |  | `'if' construct must use '{}'s.` |
| 350 | 35 | `Name 'sentence_number' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 386 |  | `Line is longer than 100 characters (found 108).` |
| 420 | 9 | `'if' is not followed by whitespace.` |
| 420 | 41 | `'{' is not preceded with whitespace.` |
| 421 |  | `'if' child has incorrect indentation level 11, expected level should be 12.` |
| 436 | 9 | `'if' is not followed by whitespace.` |
| 436 | 41 | `'{' is not preceded with whitespace.` |
### `ComplexNumber.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 5 |  | `Line is longer than 100 characters (found 102).` |
| 6 | 4 | `Unknown tag 'Auther'.` |
| 75 |  | `Line is longer than 100 characters (found 114).` |
| 79 | 9 | `'if' is not followed by whitespace.` |
| 79 | 46 | `'{' is not preceded with whitespace.` |
| 91 | 20 | `'typecast' is not followed by whitespace.` |
| 91 | 23 | `'*' is not preceded with whitespace.` |
### `Cryptography.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 |  | `File does not end with a newline.` |
| 10 | 4 | `Unknown tag 'Author'.` |
| 39 | 41 | `'{' is not preceded with whitespace.` |
| 40 |  | `Line is longer than 100 characters (found 135).` |
| 40 | 55 | `'typecast' is not followed by whitespace.` |
| 40 | 112 | `'typecast' is not followed by whitespace.` |
| 46 |  | `Line is longer than 100 characters (found 160).` |
| 47 |  | `Line is longer than 100 characters (found 108).` |
| 48 |  | `Line is longer than 100 characters (found 140).` |
| 50 |  | `Line is longer than 100 characters (found 128).` |
| 52 | 69 | `'{' is not preceded with whitespace.` |
| 54 | 9 | `'if' is not followed by whitespace.` |
| 54 | 38 | `'{' is not preceded with whitespace.` |
| 60 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 61 | 9 | `'else' is not followed by whitespace.` |
| 61 | 13 | `'{' is not preceded with whitespace.` |
| 69 |  | `Line is longer than 100 characters (found 111).` |
| 71 | 57 | `'{' is not preceded with whitespace.` |
| 73 | 9 | `'for' is not followed by whitespace.` |
| 73 | 53 | `'{' is not preceded with whitespace.` |
| 89 | 9 | `'for' is not followed by whitespace.` |
| 89 | 48 | `'{' is not preceded with whitespace.` |
| 90 | 39 | `'{' is not preceded with whitespace.` |
| 96 | 60 | `'64.0' is a magic number.` |
| 97 | 9 | `'if' is not followed by whitespace.` |
| 97 | 24 | `'1.5' is a magic number.` |
| 97 | 28 | `'{' is not preceded with whitespace.` |
| 98 | 19 | `'64' is a magic number.` |
| 99 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 100 | 14 | `'if' is not followed by whitespace.` |
| 100 | 30 | `'1.5' is a magic number.` |
| 100 | 51 | `'{' is not preceded with whitespace.` |
| 101 | 19 | `'128' is a magic number.` |
| 102 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 103 | 14 | `'if' is not followed by whitespace.` |
| 103 | 49 | `'{' is not preceded with whitespace.` |
| 104 | 19 | `'256' is a magic number.` |
| 105 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 106 | 14 | `'{' at column 14 should have line break after.` |
| 106 | 14 | `'{' is not followed by whitespace.` |
| 106 | 21 | `'512' is a magic number.` |
| 106 | 24 | `';' is not followed by whitespace.` |
| 106 | 25 | `'}' is not preceded with whitespace.` |
| 109 | 9 | `'for' is not followed by whitespace.` |
| 109 | 50 | `'{' is not preceded with whitespace.` |
| 110 | 33 | `'typecast' is not followed by whitespace.` |
| 122 | 48 | `'{' is not preceded with whitespace.` |
### `DFT.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 |  | `File does not end with a newline.` |
| 5 |  | `Line is longer than 100 characters (found 105).` |
| 6 | 4 | `Unknown tag 'Author'.` |
| 11 |  | `Line is longer than 100 characters (found 129).` |
| 13 |  | `Line is longer than 100 characters (found 123).` |
| 18 | 51 | `'{' is not preceded with whitespace.` |
| 20 | 13 | `'for' is not followed by whitespace.` |
| 20 | 53 | `'{' is not preceded with whitespace.` |
| 21 |  | `Line is longer than 100 characters (found 128).` |
| 30 |  | `Line is longer than 100 characters (found 122).` |
| 32 |  | `Line is longer than 100 characters (found 123).` |
| 36 | 9 | `'for' is not followed by whitespace.` |
| 36 | 49 | `'{' is not preceded with whitespace.` |
### `Untangler.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 |  | `File does not end with a newline.` |
| 8 | 4 | `Unknown tag 'Author'.` |
| 31 | 9 | `'for' is not followed by whitespace.` |
| 31 | 50 | `'{' is not preceded with whitespace.` |
| 32 |  | `Line is longer than 100 characters (found 102).` |
| 32 | 13 | `'if' is not followed by whitespace.` |
| 32 | 102 | `'{' is not preceded with whitespace.` |
| 37 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 38 |  | `Line is longer than 100 characters (found 107).` |
| 38 | 18 | `'if' is not followed by whitespace.` |
| 38 | 107 | `'{' is not preceded with whitespace.` |
| 43 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 44 |  | `Line is longer than 100 characters (found 164).` |
| 45 |  | `Line is longer than 100 characters (found 106).` |
| 45 | 18 | `'if' is not followed by whitespace.` |
| 45 | 106 | `'{' is not preceded with whitespace.` |
| 48 | 17 | `'for' is not followed by whitespace.` |
| 48 | 51 | `'{' is not preceded with whitespace.` |
| 49 | 21 | `'if' is not followed by whitespace.` |
| 49 | 78 | `'{' is not preceded with whitespace.` |
| 53 | 21 | `'}' at column 21 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 54 | 84 | `'{' is not preceded with whitespace.` |
| 71 | 61 | `Expected @param tag for 'input'.` |
| 71 | 67 | `'{' is not preceded with whitespace.` |
| 74 | 9 | `'for' is not followed by whitespace.` |
| 74 | 30 | `'{' is not preceded with whitespace.` |
### `NoSuitableSentenceException.java`
| Line | Column | Message |
| ---- | ------ | ------- |
### `NotFoundException.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 3 | 49 | `'{' is not preceded with whitespace.` |
### `SentenceAnalysis.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 7 | 4 | `Unknown tag 'Author'.` |
| 13 | 5 | `Redundant 'public' modifier.` |
| 13 | 76 | `'{' is not preceded with whitespace.` |
| 21 | 32 | `'{' is not preceded with whitespace.` |
| 28 | 36 | `'{' is not preceded with whitespace.` |
### `SentimentAnalysis.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 3 |  | `Using the '.*' form of import should be avoided - com.google.cloud.language.v1.*.` |
| 11 |  | `Line is longer than 100 characters (found 125).` |
| 12 | 4 | `Unknown tag 'Author'.` |
| 16 |  | `Line is longer than 100 characters (found 170).` |
| 18 |  | `Line is longer than 100 characters (found 153).` |
| 22 | 43 | `'{' is not preceded with whitespace.` |
| 25 | 9 | `'for' is not followed by whitespace.` |
| 25 | 51 | `'{' is not preceded with whitespace.` |
| 26 | 94 | `'{' is not preceded with whitespace.` |
| 30 | 9 | `'if' is not followed by whitespace.` |
| 30 | 54 | `'0.3' is a magic number.` |
| 30 | 58 | `'{' at column 58 should have line break after.` |
| 30 | 58 | `'{' is not followed by whitespace.` |
| 30 | 58 | `'{' is not preceded with whitespace.` |
| 30 | 98 | `';' is not followed by whitespace.` |
| 30 | 99 | `'}' is not preceded with whitespace.` |
| 35 |  | `Line is longer than 100 characters (found 170).` |
| 37 |  | `Line is longer than 100 characters (found 153).` |
| 44 | 9 | `'for' is not followed by whitespace.` |
| 44 | 51 | `'{' is not preceded with whitespace.` |
| 45 | 94 | `'{' is not preceded with whitespace.` |
| 49 | 9 | `'if' is not followed by whitespace.` |
| 49 | 54 | `'-0.3' is a magic number.` |
| 49 | 59 | `'{' at column 59 should have line break after.` |
| 49 | 59 | `'{' is not followed by whitespace.` |
| 49 | 59 | `'{' is not preceded with whitespace.` |
| 49 | 99 | `';' is not followed by whitespace.` |
| 49 | 100 | `'}' is not preceded with whitespace.` |
| 54 |  | `Line is longer than 100 characters (found 150).` |
| 55 |  | `Line is longer than 100 characters (found 101).` |
| 56 |  | `Line is longer than 100 characters (found 173).` |
| 57 |  | `Line is longer than 100 characters (found 155).` |
| 59 | 89 | `'{' is not preceded with whitespace.` |
| 60 | 78 | `'{' is not preceded with whitespace.` |
| 63 | 13 | `'for' is not followed by whitespace.` |
| 63 | 57 | `'{' is not preceded with whitespace.` |
| 64 |  | `Line is longer than 100 characters (found 127).` |
| 66 |  | `Line is longer than 100 characters (found 109).` |
| 69 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 70 | 32 | `'{' is not preceded with whitespace.` |
### `DocumentSimilarity.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 6 |  | `Using the '.*' form of import should be avoided - java.util.*.` |
| 21 |  | `Line is longer than 100 characters (found 116).` |
| 22 |  | `'array initialization' child has incorrect indentation level 12, expected level should be one of the following: 8, 41, 44.` |
| 22 | 92 | `',' is not followed by whitespace.` |
| 42 | 16 | `Name 'p_i' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 42 | 21 | `Name 'q_i' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 42 | 26 | `Name 'm_i' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 42 | 31 | `Name 'div_p' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 42 | 38 | `Name 'div_q' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 72 |  | `'array initialization' child has incorrect indentation level 16, expected level should be one of the following: 12, 25, 28.` |
| 74 | 18 | `Name 'doc1_metrics' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 75 | 18 | `Name 'doc2_metrics' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 133 | 41 | `Name 'word_probability' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 133 | 66 | `Name 'average_probability' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 158 | 32 | `'/' is not followed by whitespace.` |
| 158 | 32 | `'/' is not preceded with whitespace.` |
| 162 |  | `Line is longer than 100 characters (found 101).` |
| 167 | 41 | `Expected @param tag for 'doc'.` |
| 173 | 27 | `'docWords' hides a field.` |
| 182 | 32 | `Literal Strings should be compared using equals(), not '!='.` |
| 200 |  | `Line is longer than 100 characters (found 101).` |
| 241 | 40 | `Expected @param tag for 'doc'.` |
| 252 |  | `Line is longer than 100 characters (found 111).` |
| 254 | 57 | `'{' is not preceded with whitespace.` |
| 256 | 9 | `'for' is not followed by whitespace.` |
| 256 | 53 | `'{' is not preceded with whitespace.` |
| 267 | 40 | `Expected @param tag for 'doc'.` |
### `GroupingDocuments.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 26 |  | `Line is longer than 100 characters (found 104).` |
| 34 | 23 | `'=' is not followed by whitespace.` |
| 40 | 9 | `'for' is not followed by whitespace.` |
| 44 | 9 | `'for' is not followed by whitespace.` |
| 45 | 13 | `'for' is not followed by whitespace.` |
| 45 | 26 | `'+' is not followed by whitespace.` |
| 45 | 26 | `'+' is not preceded with whitespace.` |
| 46 |  | `Line is longer than 100 characters (found 133).` |
| 46 | 97 | `',' is not followed by whitespace.` |
| 50 | 9 | `'for' is not followed by whitespace.` |
| 61 |  | `Line is longer than 100 characters (found 134).` |
| 61 | 39 | `'typecast' is not followed by whitespace.` |
| 61 | 95 | `'typecast' is not followed by whitespace.` |
| 61 | 134 | `'{' is not preceded with whitespace.` |
| 68 | 15 | `'while' is not followed by whitespace.` |
| 71 |  | `Line is longer than 100 characters (found 141).` |
| 71 | 37 | `'typecast' is not followed by whitespace.` |
| 71 | 91 | `'typecast' is not followed by whitespace.` |
| 72 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 73 | 13 | `Catching 'Exception' is not allowed.` |
| 73 | 32 | `'{' is not preceded with whitespace.` |
| 88 |  | `Line is longer than 100 characters (found 130).` |
| 89 |  | `Line is longer than 100 characters (found 125).` |
| 92 |  | `Line is longer than 100 characters (found 116).` |
| 93 |  | `Line is longer than 100 characters (found 103).` |
| 96 |  | `Expected @return tag.` |
| 101 | 9 | `'for' is not followed by whitespace.` |
| 102 | 13 | `'for' is not followed by whitespace.` |
| 102 | 27 | `'+' is not followed by whitespace.` |
| 109 | 31 | `'+' is not followed by whitespace.` |
| 109 | 31 | `'+' is not preceded with whitespace.` |
| 117 | 13 | `'for' is not followed by whitespace.` |
| 120 | 26 | `'typecast' is not followed by whitespace.` |
| 120 | 44 | `'typecast' is not followed by whitespace.` |
| 129 |  | `Line is longer than 100 characters (found 112).` |
| 137 |  | `Line is longer than 100 characters (found 142).` |
| 153 |  | `Line is longer than 100 characters (found 108).` |
| 154 |  | `Line is longer than 100 characters (found 110).` |
| 166 | 35 | `'-' is not followed by whitespace.` |
| 166 | 38 | `')' is preceded with whitespace.` |

