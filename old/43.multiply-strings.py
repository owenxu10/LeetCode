class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        '''
        23 * 23 = 20 * 20 + 20 * 3 + 20 * 3 + 3 * 3
        '''
        sum = 0
        multi1 = 1
        for i in num1[::-1]:
            multi2 = 1
            num1 = multi1 * int(i)
            for j in num2[::-1]:
                sum += num1 * int(j) * multi2
                multi2 *= 10
            multi1 *= 10
        return str(sum)  
