def selectSort(nums):
    for i in range(0, len(nums)):
        smallestIndex = i
        for j in range(i, len(nums)):
            if nums[j] < nums[smallestIndex]:
                smallestIndex = j
        change(nums, i, smallestIndex)

    return nums


def insertSort(nums):
    for i in range(1, len(nums)):
        j = i - 1
        while (j >= 0):
            if (nums[i] < nums[j]):
                change(nums, i, j)
                i = j
            j -= 1

    return nums


def shellSort(nums):
    pass


def change(nums, this, that):
    temp = nums[this]
    nums[this] = nums[that]
    nums[that] = temp


print(selectSort([2, 4, 6, 1, 5, 6, 7, 1, 7, 2]))
print(insertSort([2, 4, 6, 1, 5, 6, 7, 1, 7, 2]))
