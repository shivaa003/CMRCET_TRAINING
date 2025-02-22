#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

class DigitalWallet {
private:
    map<int, int> wallet;

public:
    void addUser(int userID, int initialBalance) {
        if (wallet.find(userID) == wallet.end()) {
            wallet[userID] = initialBalance;
            cout << "User " << userID << " added with balance " << initialBalance << endl;
        } else {
            cout << "User " << userID << " already exists!" << endl;
        }
    }

    void makeTransaction(int fromUserID, int toUserID, int amount) {
        if (wallet.find(fromUserID) == wallet.end()) {
            cout << "Failure: User " << fromUserID << " does not exist!" << endl;
            return;
        }
        if (wallet.find(toUserID) == wallet.end()) {
            cout << "Failure: User " << toUserID << " does not exist!" << endl;
            return;
        }
        if (wallet[fromUserID] < amount) {
            cout << "Failure: User " << fromUserID << " has insufficient balance!" << endl;
            return;
        }

        wallet[fromUserID] -= amount;
        wallet[toUserID] += amount;
        cout << "Success: " << amount << " transferred from User " << fromUserID << " to User " << toUserID << endl;
    }

    void displaySortedBalances() {
        vector<pair<int, int>> vec(wallet.begin(), wallet.end());
        sort(vec.begin(), vec.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            if (a.second == b.second) {
                return a.first < b.first;
            }
            return a.second < b.second;
        });

        cout << "\nSorted Balances:" << endl;
        for (const auto& p : vec) {
            cout << "User " << p.first << ": " << p.second << endl;
        }
    }

    void showBalance(int userID) {
        if (wallet.find(userID) != wallet.end()) {
            cout << "User " << userID << " has balance: " << wallet[userID] << endl;
        } else {
            cout << "User " << userID << " does not exist!" << endl;
        }
    }
};

void displayMenu() {
    cout << "\nDigital Wallet Menu:" << endl;
    cout << "1. Add a User" << endl;
    cout << "2. Make a Transaction" << endl;
    cout << "3. Display Sorted Balances" << endl;
    cout << "4. Show User Balance" << endl;
    cout << "5. Exit" << endl;
}

int main() {
    DigitalWallet wallet;
    int choice;

    while (true) {
        displayMenu();
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                int userID, initialBalance;
                cout << "Enter user ID and initial balance: ";
                cin >> userID >> initialBalance;
                wallet.addUser(userID, initialBalance);
                break;
            }
            case 2: {
                int fromUser, toUser, amount;
                cout << "Enter transaction (fromUser toUser amount): ";
                cin >> fromUser >> toUser >> amount;
                wallet.makeTransaction(fromUser, toUser, amount);
                break;
            }
            case 3:
                wallet.displaySortedBalances();
                break;
            case 4: {
                int userID;
                cout << "Enter user ID to check balance: ";
                cin >> userID;
                wallet.showBalance(userID);
                break;
            }
            case 5:
                cout << "Exiting Digital Wallet program..." << endl;
                return 0;
            default:
                cout << "Invalid choice. Please try again!" << endl;
        }
    }

    return 0;
}
