class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """

        for row in xrange((len(matrix)+1)/2):
            for column in xrange(len(matrix[row])):
                other = len(matrix)-row-1
                matrix[other][column], matrix[row][column] = matrix[row][column],matrix[other][column] 

        columns = 0

        for row in xrange(len(matrix)):
            columns += 1
            for column in xrange(columns):
                matrix[column][row],matrix[row][column] = matrix[row][column], matrix[column][row]

