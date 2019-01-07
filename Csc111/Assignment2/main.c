/*
 *  Author:      Shayla Grymaloski
 *  UVicID:      V00884262
 *  Date:        Sep 19, 2017
 *  File name:   V00884262_A2_Pt1.c
 *  Description: Generates
 */

#include <stdio.h>
#include <stdlib.h>



void question_1(void){
    const float maxcelcius = 60.0;
    const float mincelcius = -40.0;
    float cels = mincelcius;
    float fahr;
    for (cels; cels <= maxcelcius; (cels = cels + 5)) {
        fahr = (cels * 9.0 / 5.0) + 32.0;
        printf("%6.1f degs C = %6.1f degs F\n", cels, fahr);
    }

}

/* ArithmeticSequence(start, increment, count)
   Print an arithmetic sequence with the provided properties:
    - start: first value in the sequence
    - increment: the increment value between each pair of values in the sequence
    - count: number of terms to generate
*/
void ArithmeticSequence(int start, int increment, int count){
    printf("Arthmetic sequence: ");
    for(count; 0 <= count; count--) {
        printf("%d ", start);
        start = start + increment;
    }


    printf("\n");
}/*ArithmeticSequence*/



/* LeonardoSequence(k, count)
   Print count terms of the Leonardo sequence starting with the kth term
*/
void LeonardoSequence(int start, int count) {
    int firstNum = 1;
    int secondNum = 1;
    int k = 1;
    int x = 1;

    printf("LeonardoSequence: ");
    while (x == 1) {
        if (k == start) {
            for (count; count > 0; count--) {
                printf("%d ", k);
                k = firstNum + secondNum;
                k++;
                firstNum = secondNum;
                secondNum = k;
            }
            x = 0;
        }
        k = firstNum + secondNum;
        k++;
        firstNum = secondNum;
        secondNum = k;
    }


    printf("\n");
}/*LeonardoSequence*/

/* HarmonicSequence(k, count)
   Print count terms of the harmonic sequence starting with the kth term
*/
void HarmonicSequence(int k, int count){
    printf("HarmonicSequence: ");
    for (count; count>= 1; count --){


        double num = (double) 1 / k;

        printf("%.3lf ",num );
        k++;
    }
    printf("\n");
}/*HarmonicSequence*/

void question_2(void){
    ArithmeticSequence(17, 6, 5);
    ArithmeticSequence(34, 6, 8);
    LeonardoSequence(1, 7);
    LeonardoSequence(9, 7);
    HarmonicSequence(1, 6);
    HarmonicSequence(3, 6);
}
/* Do not change any code below this line */

void question_3(void){
    double x = 1.0;
    double y;
    int i;
    int t = 117;
    double squared;

    for(i = 1; i <= 10; i++){
        printf("Iteration %d:\t",i);
        printf("%f\n", x);
        y = x - (x*x-t)/(2*x);
        x = y;
    }
    i --;

    printf("The square root of %d with %d iterations is %f\n",t,i,y);

    squared = y*y;
    printf("The square of %f is %f\n",y,squared);
}

int main(void) {

    question_1();
    printf("\n\n");
    question_2();
    printf("\n\n");
    question_3();

    return EXIT_SUCCESS;
} /*main*/