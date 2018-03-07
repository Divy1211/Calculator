# Calculator
1. I have coded a calculator in java, my code is a bit messy but i think it will be readable enough you can simply run the code by compiling the java file and then running it.
2. If you find a bug you can open a pull request

# Prerequisities
1. You should have Java installed.

# How the program works

1. Calculator GUI 

![Normal](https://github.com/Divy1211/Calculator/blob/master/images/Capture.PNG)

![Inverse](https://github.com/Divy1211/Calculator/blob/master/images/Cap4ture.PNG)

![Complex Mode](https://github.com/Divy1211/Calculator/blob/master/images/Screenshot (185).PNG)

![Inverse for Complex Mode](https://github.com/Divy1211/Calculator/blob/master/images/Screenshot (186).PNG)
2. To use the calculator just type the number in the text field and press the operation. It will give an output. For operations where 2 variables are involed like Log y(x), enter value of x first ***ALWAYS*** then press the funtion then the text field will be cleared then enter the value of y and press = sign. it will give the output. currently it does not show the operation performed just the output. I plan to change it in the future. There is also a sort operation for which you need to enter the numbers sperated with ***ONE*** space for example enter 1 3 5 7 9 0 2 4 6 8 and click sort and then the output will be 0 1 2 3 4 5 6 7 8 9. the number of numbers you enter like this does not have a limit.

3. As shown in the images above the calculator has inverse funtions. It supports the 2 mathematical constants π and e

4. It supports complex numbers. There are a few things to keep in mind while working with complex numbers. They are:
i) Always enter the number in the format x +yi where x is the real part and y is the imaginary part.
ii) The space between x and +yi is important.
iii) The plus can be a minus sign incase the imaginary part is negetive.
iv) The numbers cannot be raised to complex powers or complex roots yet. For instance e^iπ wont work.
v) There is no support for trigonotmetric functions on complex numbers yet.
vi) arcCos(2) and arcSin(2) which have complex answers will give a wrong output as of now.
