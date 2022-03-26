#ifndef SONDA_H
#define SONDA_H

#include <tuple>
#include <map>

using std::tuple;
using std::map;


class Sonda {
    public:
        // Constructors
        Sonda();
        Sonda(int _x, int _y, char _direction);

        // Getter
        tuple<int, int, char> get_position() const;

        // Setter with invariant
        void set_position(int _x, int _y);

        void move(char command);

        friend bool sonda_valid_move(const Sonda& sonda);

        const static map<char, int> number_of_direction;
        const static map<int, char> symbol_of_direction;
        const static map<char, int> rotation;
        const static int dx[4], dy[4];
    private:
        int x, y;
        int direction;
};

// auxiliary functions
bool valid_x(int x);

bool valid_y(int y);

bool sonda_valid_move(const Sonda& sonda);

void print_position(const Sonda& sonda);

#endif