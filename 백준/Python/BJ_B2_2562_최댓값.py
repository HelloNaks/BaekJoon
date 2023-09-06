test_list = []
for i in range(9):
    test_list.append(int(input()))
print(max(test_list))
print(test_list.index(max(test_list))+1)
