class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        '''
        two pointer: p_left and p_right
        two bar: leftHeight and rightHeight
        choose the smaller bar and add into sum
        '''
        p_left = 0
        p_right = len(height)-1

        if p_right < 0:
            return 0

        leftHeight = height[p_left]
        rightHeight = height[p_right]
        sum = 0

        while p_left < p_right :
            if leftHeight < rightHeight:
                sum += (leftHeight - height[p_left])
                p_left+=1
                if height[p_left] > leftHeight:
                    leftHeight = height[p_left]
            else:
                sum += (rightHeight - height[p_right])
                p_right-=1
                if height[p_right] > rightHeight:
                    rightHeight = height[p_right]
        return sum
