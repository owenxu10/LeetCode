class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        '''
        DP
        T[i][j]:
        1) ? or same char: T[i-1][j-1]
        2) *: T[i-1][j] || T[i][j-1]
        3) false 
        '''
        T = [[False for i in xrange(len(p)+1)]for j in xrange(len(s)+1)]
        print(T)

        if len(s) == 0 and p == "*":
            return True

        T[0][0] = True

        for ps in xrange(len(s)):
            for pp in xrange(len(p)):
                if p[pp] == s[ps] or p[pp] == '?':
                    T[ps+1][pp+1] = T[ps][pp]
                elif p[pp] == '*':
                    T[ps+1][pp+1] = T[ps][pp+1] or T[ps+1][pp]
                else:
                    T[ps+1][pp+1] = False

        return T[len(s)][len(p)]
