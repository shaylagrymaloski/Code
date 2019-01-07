/*
Name: Shayla Grymaloski
UVicID: V00884262
Date: 2017/10/08
File names: V00884262A3P2.c : Computes the v, r or h of a cone given two out to the three values
 */

#include <stdio.h>
#include <math.h>
#include <stdlib.h>


int main() {
    int count = 1;
    double r;
    double h;
    double v;
    double third = 1.0/3.0;
    int num;
    int x = 1;

    printf("Welcome to the cone calulator\n");

    while(x ==1){

        num = rand()%4;


        if (num == 1){
            printf("Enter r and h: ");
            fflush(stdout);
            scanf("%lf %lf", &r, &h);

            v = third*M_PI*r*r*h;

            printf("%d ConeCalc: r = %.2lf h = %.2lf v = %.2lf\n",count, r, h,v);
            count++;

        }
        else if (num == 2){
            printf("Enter r and v: ");
            fflush(stdout);
            scanf("%lf %lf", &r, &v);

            h = (third*M_PI*r*r)/v;
            printf("%d ConeCalc: r = %.2lf h = %.2lf v = %.2lf\n",count, r, h,v);
            count++;
        }
        else if (num == 3){
            printf("Enter h and v: ");
            fflush(stdout);
            scanf("%lf %lf", &h, &v);
            r = sqrt((third*M_PI*h)/v);
            printf("%d ConeCalc: r = %.2lf h = %.2lf v = %.2lf\n",count, r, h,v);
            count++;

        }else if(count > 5 && num ==0 ){
            printf("Bye");
            break;
        }

    }
return EXIT_SUCCESS;
}