#include <iostream>

// redefining a function with same prototype is not possible
// we can use namespaces to do this
// helpful to remove clashes between libraries
// to specify which namespace you function you are referring to
// you can use the name of the namespace along with :: operator
// to avoid writing :: again and again we can simply use "using" keyword

namespace fooish {
    void foo(const int &x) {
        std::cout << x * 2 << std::endl;
    }
}


namespace fuuish {
    void foo(const int &x) {
        std::cout << x * 2 << std::endl;
    }
}

int main() {
    fuuish::foo(5);
    fooish::foo(5);
    // after using "using" keyword, :: operator is not needed
    using namespace fooish;
    foo(7);
}