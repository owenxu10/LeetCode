class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        str = ''
        list = []
        self.gen(list, str, n)
        return list


    def gen(self, list, str, n):
        if str.count('(') > str.count(')'):
            str2 = str + ')'
            if str2.count('(') == n and str2.count(')') == n:
                list.append(str2)
            else:
                self.gen(list, str2, n)

        if str.count('(') < n:
            str2 = str + '('
            if str2.count('(') == n and str2.count(')') == n:
                list.append(str2)
            else:
                self.gen(list, str2, n)


if __name__ == '__main__':
    s = Solution()

    list = s.generateParenthesis(3)

    print(list)
