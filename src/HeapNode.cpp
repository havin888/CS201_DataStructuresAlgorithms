
#include "HeapNode.h"

HeapNode::HeapNode(int data, int name) {
    this->data = data;
    this->name = name;
}

int HeapNode::getData() const{
    return data;
}

int HeapNode::getName() const{
    return name;
}

HeapNode::HeapNode() {

}

void HeapNode::setData(int _data) {
    this->data = _data;
}
