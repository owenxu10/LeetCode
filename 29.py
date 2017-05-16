import os


def divide(dividend, divisor):
    """
    :type dividend: int
    :type divisor: int
    :rtype: int
    """

    positive = (dividend < 0) is (divisor < 0)
    dd, ds = abs(dividend), abs(divisor)
    res = 0
    while (dd >= ds):
        shift = 0
        while (dd >= (ds << shift)):
            shift += 1
        res += 1 << (shift - 1)
        dd -= ds << (shift - 1)

    if not positive:
        res = -res

    return max(-2147483648, min(res, 2147483647))


print(divide(20, 2))
