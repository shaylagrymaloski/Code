// Example program
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int calcHashVal(std::string str, int n){
    int result = 0;
    for(char& c : str) {
        result = int(c) + result;
    }
    return result%11;
}

void insertHash(std::vector<std::vector<std::string> > &vec, std::string str, int n){
    std::string temp;
    for(int i = 0; i< str.length()-n; i ++ ){
      std::string substring = str.substr(i, i+n);
      int val = calcHashVal(substring, n);
      vec[val].push_back(substring);
   }

}
std::string mostOccuringString(std::vector<std::vector<std::string> > &vec,int n){
    // sort all of the "chains"
    int maxStringCount;
    std::string currMaxString;

    for(int i = 0; i< sizeof(vec); i ++ ){
        std::sort(vec[i].begin(), vec[i].end());
    }

    for(int i = 0; i< sizeof(vec); i ++ ){
        if(sizeof(vec[i]) == 0 ){
            continue;
        }
        int count = 0;
        for(int j = 0; j< sizeof(vec[i]); j++ ){
            count ++;
            if(vec[i][j] != vec[i][j+1]){
                if(count > maxStringCount){
                    maxStringCount = count;
                    currMaxString = vec[i][j];
                }
                count = 0;
            }
        }
    }

    return currMaxString;
}


int main()
{
    int i,j,n;
    std::string str;
    
    // Taking input
    std::cin>>n;
    std::cin>>str;
    
    std::vector<std::vector<std::string> > vec(7); 

    // Write your hash function and calculate hash for each index
    insertHash(vec, str, n);

    
    
    // Determine which hash appears the most, save it's starting index 
    str = mostOccuringString(vec,n);

    // Output the result
    std::cout << str;

return 0;
}