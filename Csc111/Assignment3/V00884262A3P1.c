
/*
Name: Shayla Grymaloski
UVicID: V00884262
Date: 2017/10/08
File names: V00884262A3P1.c : Library of functions that use the height and radius of different shapes to calculate the volume or surface area
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define RadiusRange1 (7.3)
#define RadiusInc (0.7)
#define RadiusRange2 (13.2)
#define CylinderHeight1 (8.2)
#define CylinderHeightInc (1.5)

double volSphere(double r){
    return (4/3)*M_PI*r*r*r;
}
double SASphere(double r){
    return 4*M_PI*r*r;
}
double SACylinder(double r, double h){
    double rect = 2*M_PI*r*h;
    double square = 2*M_PI*r*r;
    return rect +square;
}
double areaCircle(double r){
    return M_PI*r*r;
}/*areaCircle*/

double periCircle(double r){
    return M_PI*(r+r);
}/*periCircle*/

double volCylinder(double r, double h){
    double areaCi = areaCircle(r);
    double volCy = h*areaCi;
    return volCy;
}/*volCylinder*/

double volCone(double r, double h){
    return M_PI*r*r*(h/3);
}

double SACone(double r, double h){
    double cir = areaCircle(r);
    return cir + M_PI*r*sqrt((h*h)+(r*r));

}

int main() {
    double radius = 7.3;
    double height = 8.2;


    for (int i = 0; i < 4; ++i) {
        printf("%8s ", "01234567");
    }
    printf("%10s","0123456789");
    printf("\n");
    printf("%8s %8s %8s %8s %10s", "Radius", "CirArea", "CircPeri","CylHei", "CylVol");
    printf("\n");

    for (int j = 0; j < 9; ++j) {
        double area = areaCircle(radius);
        double cirPer = periCircle(radius);
        double cylVol = volCylinder(radius,height);

        printf("%8.1lf %8.2lf %8.2lf %8.1lf %10.2lf", radius, area, cirPer,height,cylVol);
        printf("\n");
        radius += 0.7;
        height += 1.5;

    }

    return EXIT_SUCCESS;
}