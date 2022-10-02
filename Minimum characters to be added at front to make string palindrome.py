def computeLPSArray(string):
 
    M = len(string)
    lps = [None] * M
 
    length = 0
    lps[0] = 0 # lps[0] is always 0
 
    # the loop calculates lps[i]
    # for i = 1 to M-1
    i = 1
    while i < M:
     
        if string[i] == string[length]:
         
            length += 1
            lps[i] = length
            i += 1
         
        else: # (str[i] != str[len])
         
            # This is tricky. Consider the example.
            # AAACAAAA and i = 7. The idea is
            # similar to search step.
            if length != 0:
             
                length = lps[length - 1]
 
                # Also, note that we do not
                # increment i here
             
            else: # if (len == 0)
             
                lps[i] = 0
                i += 1
 
    return lps

class Solution:
    def minChar(self,string):
        #Write your code here
        revStr = string[::-1]
 
        # Get concatenation of string,
        # special character and reverse string
        concat = string + "$" + revStr
 
        # Get LPS array of this
        # concatenated string
        lps = computeLPSArray(concat)
 
        # By subtracting last entry of lps
        # vector from string length, we
        # will get our result
        return len(string) - lps[-1]


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__=="__main__":
    for _ in range(int(input())):
        s=input()
        obj=Solution()
        ans=obj.minChar(s)
        print(ans)
# } Driver Code Ends
