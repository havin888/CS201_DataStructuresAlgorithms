cmake_minimum_required(VERSION 3.29)
project(CS201_DataStructuresAlgorithms)

set(CMAKE_CXX_STANDARD 14)

include_directories(src)

add_executable(CS201_DataStructuresAlgorithms
    src/Heap.cpp
    src/Heap.h)
