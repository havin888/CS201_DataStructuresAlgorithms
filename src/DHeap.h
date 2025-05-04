
#ifndef DATASTRUCTURES_CPP_DHEAP_H
#define DATASTRUCTURES_CPP_DHEAP_H


#include "Heap.h"

class DHeap : public Heap{
protected:
    int d;
public:
    DHeap(int N, int d);
};


#endif //DATASTRUCTURES_CPP_DHEAP_H
