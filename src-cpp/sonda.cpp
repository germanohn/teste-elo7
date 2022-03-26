#include <iostream>
#include <tuple>
#include "sonda.h"


extern int max_x, max_y;

const int MOD = 4;


// const static member variables of class Sonda

const map<char, int> Sonda::number_of_direction = {
    {'N', 0}, {'E', 1}, {'S', 2}, {'W', 3}
};

const map<int, char> Sonda::symbol_of_direction = {
    {0, 'N'}, {1, 'E'}, {2, 'S'}, {3, 'W'}
};

const map<char, int> Sonda::rotation = {
    {'L', -1}, {'R', 1}
};

const int Sonda::dx[4] = {0, 1, 0, -1}; // N, E, S, W

const int Sonda::dy[4] = {1, 0, -1, 0}; // N, E, S, W


// constructors of class Sonda

Sonda::Sonda() : x(0), y(0), direction(0) {}

Sonda::Sonda(int _x, int _y, char _direction) :
    direction(Sonda::number_of_direction.at(_direction)) {
    set_position(_x, _y);
}


// member methods of class Sonda

tuple<int, int, char> Sonda::get_position() const {
    return std::make_tuple(x, y,
                    Sonda::symbol_of_direction.at(direction));
}

void Sonda::set_position(int _x, int _y) {
    // TODO: write an exception here for invalid coordinates
    if (valid_x(_x) && valid_y(_y)) {
        Sonda::x = _x;
        Sonda::y = _y;
    }
}

void Sonda::move(char command) {
    if (command == 'L' || command == 'R') {
        Sonda::direction = (Sonda::direction +
            Sonda::rotation.at(command) + MOD) % MOD;
    } else { // command == 'M'
        // ? TODO: write an exception for invalid move?
        if (sonda_valid_move(*this)) {
            Sonda::x += Sonda::dx[Sonda::direction];
            Sonda::y += Sonda::dy[Sonda::direction];
        }
    }
}


// auxiliary functions

bool valid_x(int x) {
    return x >= 0 && x <= max_x;
}

bool valid_y(int y) {
    return y >= 0 && y <= max_y;
}

bool sonda_valid_move(const Sonda& sonda) {
    return valid_x(sonda.x + Sonda::dx[sonda.direction]) &&
            valid_y(sonda.y + Sonda::dy[sonda.direction]);
}

void print_position(const Sonda& sonda) {
    int x, y;
    char direction;
    std::tie(x, y, direction) = sonda.get_position();
    std::cout << x << " " << y << " " << direction << "\n";
}