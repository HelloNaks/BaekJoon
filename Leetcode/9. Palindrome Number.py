class Solution(object):
    def isPalindrome(self, x):
        x = str(x)
        length = len(x)
        ret = True
        for i in range(length/2):
            if x[i] != x[length-1-i]:
                ret = False
                break
            else:
                continue
        return ret
        