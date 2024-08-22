#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

void sortedBalance(map<int, int>& m) {
    vector<pair<int, int>> vec(m.begin(), m.end());
    sort(vec.begin(), vec.end(), [](pair<int, int> a, pair<int, int> b) {
        if (a.second == b.second) {
            return a.first < b.first;
        }
        return a.second < b.second;
    });
    for (auto& p : vec) {
        cout << p.first << " " << p.second << endl;
    }
}

void SuccessOrFailure(map<int, int>& m, int* array1, int* array2, int* amount, int n) {
    for (int i = 0; i < n; i++) {
        auto it1 = m.find(array1[i]);
        auto it2 = m.find(array2[i]);
        if (it1 != m.end() && it2 != m.end() && it1->second > amount[i]) {
            it2->second += amount[i];
            it1->second -= amount[i];
            cout << "Success" << endl;
        } else {
            cout << "Failure" << endl;
        }
    }
    cout << endl;
}

int main() {
    int n1;
    cin >> n1;
    map<int, int> m;
    for (int i = 0; i < n1; i++) {
        int key, value;
        cin >> key >> value;
        m[key] = value;
    }
    int n2;
    cin >> n2;
    int* array1 = new int[n2];
    int* array2 = new int[n2];
    int* amount = new int[n2];
    for (int i = 0; i < n2; i++) {
        cin >> array1[i] >> array2[i] >> amount[i];
    }
    SuccessOrFailure(m, array1, array2, amount, n2);
    sortedBalance(m);
    delete[] array1;
    delete[] array2;
    delete[] amount;
    return 0;
}