class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: strn
        """
        n = n-1
        result = 1
        for i in range(n):
            result = self.getRes(result)

        return str(result)

    def getRes(self, n):
        number = str(n)
        start = 0
        count = 0
        currentValue = number[0]
        result = ""
        for i in range(len(number)):
            if currentValue == number[i]:
                count += 1
            else:
                result = result + str(count) + str(currentValue)
                currentValue = number[i]
                count = 1

        result = result+ str(count) + str(currentValue)
        return result


s = Solution()
print(s.countAndSay(2))