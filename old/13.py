class Solution(object):
    def convert(self, s):
        n = 0
        if s == 'I':
            n = 1
        elif s == 'X':
            n = 10
        elif s == 'C':
            n = 100
        elif s == 'M':
            n = 1000
        elif s == 'V':
            n = 5
        elif s == 'L':
            n = 50
        elif s == 'D':
            n = 500
        return n

    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        sum = 0
        for i in range(0, len(s)):
            number = self.convert(s[i])
            sum = sum + number
            if i < len(s) - 1 and self.convert(s[i]) < self.convert(s[i + 1]):
                sum = sum - self.convert(s[i]) * 2

        return sum

if __name__ =="__main__":
    s = Solution()
    print(s.romanToInt('MCMLXXX'))
