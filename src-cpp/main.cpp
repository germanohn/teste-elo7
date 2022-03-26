#include <iostream>
#include <string>
#include <limits>
#include "sonda.h"
using std::cin;


int max_x, max_y;

int main() {
    cin >> max_x >> max_y;

    int x, y;
    char direction;
    while (cin >> x >> y >> direction) {
        cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
        Sonda sonda(x, y, direction);

        std::string instructions;
        std::getline(cin, instructions);
        for (char instruction : instructions) {
            sonda.move(instruction);
        }

        print_position(sonda);
    }
}