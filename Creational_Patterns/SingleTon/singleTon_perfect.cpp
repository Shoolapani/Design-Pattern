#include <bits/stdc++.h>
#include <thread>
#include <chrono>
#include <mutex>
#include <condition_variable>
using namespace std::chrono;
using namespace std;

std::mutex m1;

class SingleTon
{
public:
    ~SingleTon()
    {
        // use mutex lock
        std::unique_lock<mutex> ul(m1);

        if (instanceSingleTon != nullptr)
        {
            cout << "Des....." << endl;
            delete instanceSingleTon;
            instanceSingleTon = nullptr;
        }
        // use mutex unlock
    }

    // copy constructor
    SingleTon(const SingleTon &) = delete;

    // copy assignment operator
    SingleTon &operator=(SingleTon const &) = delete;

    void set(int val);
    void get()
    {
        cout << this->val << endl;
    }

    static SingleTon *getInstance()
    {
        // use mutex lock
        std::unique_lock<mutex> ul(m1);
        if (instanceSingleTon == nullptr)
        {
            instanceSingleTon = new (std::nothrow) SingleTon();
        }
        return instanceSingleTon;
    }

private:
    static SingleTon *instanceSingleTon;
    SingleTon() : val(0){};
    int val;
};

SingleTon *SingleTon::instanceSingleTon = nullptr;

void SingleTon::set(int val)
{
    this->val = val;
}

int main()
{
    // use eager instantiation for multi threaded as mutex is costly sometimes.
    SingleTon *singleTon = SingleTon::getInstance();
    SingleTon *singleTon2 = singleTon;

    singleTon->set(20);
    // singleTon->get();
    singleTon2->set(50);
    singleTon2->get();
    singleTon->get();

    // now use n - thread after this

    return 0;
}