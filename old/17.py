class Solution(object):
    phone = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
    }

    def LetterCombination(self, num):
        result = []
        new_result = []
        for i in range(0, len(num)):
            if int(num[i]) > 1:
                if len(result) > 0:
                    for j in range(0, len(result)):
                        prefix = result.pop()
                        curValue = self.phone[num[i]]
                        for k in range(0, len(curValue)):
                            new_result.append(prefix + curValue[k])
                    result = new_result
                    new_result = []
                else:
                    curValue = self.phone[num[i]]
                    for j in range(0, len(curValue)):
                        result.append(curValue[j])
        return result


s = Solution()
print(s.LetterCombination('12302'))
